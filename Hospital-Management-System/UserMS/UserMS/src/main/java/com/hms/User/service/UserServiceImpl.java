package com.hms.User.service;

import com.hms.User.dto.UserDTO;
import com.hms.User.entity.User;
import com.hms.User.exception.HmException;
import com.hms.User.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private ApiService apiService;

    @Override
    public UserDTO register(UserDTO userDTO) throws HmException {
        if (userRepository.findByUsername(userDTO.getUsername()).isPresent()) {
            throw new HmException(getMessage("user.username.exists"));
        }
        Optional<User> optionalUser = userRepository.findByEmail(userDTO.getEmail());
        if (optionalUser.isPresent()) {
            throw new HmException(getMessage("user.email.exists"));
        }
        User user = userDTO.toEntity();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Long profileId;
        try {
            profileId = apiService.addProfile(userDTO).block();
        } catch (org.springframework.web.reactive.function.client.WebClientResponseException exception) {
            throw new HmException("Profile service error: " + exception.getResponseBodyAsString(), exception);
        } catch (RuntimeException exception) {
            throw new HmException("Unable to create profile. Error: " + exception.getMessage(), exception);
        }
        userDTO.setProfileId(profileId);
        user.setProfileId(profileId);
        User savedUser = userRepository.save(user);
        return savedUser.toDTO();
    }


    @Override
    public UserDTO login(String email, String password) throws HmException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new HmException(getMessage("user.login.invalid")));
        
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new HmException(getMessage("user.login.invalid"));
        }
        user.setPassword(null);
        return user.toDTO();
    }

    @Override
    public UserDTO findUserById(Long id) throws HmException {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new HmException(getMessage("user.not.found", id)));
        return user.toDTO();
    }

    @Override
    public UserDTO getUser(Long id) throws HmException {
        return findUserById(id);
    }

    @Override
    public UserDTO getUser(String email) throws HmException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new HmException(getMessage("user.not.found")));
        return user.toDTO();
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) throws HmException {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new HmException(getMessage("user.not.found", id)));
        
        existingUser.setUsername(userDTO.getUsername());
        existingUser.setEmail(userDTO.getEmail());
        existingUser.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        existingUser.setRole(userDTO.getRole());

        User updatedUser = userRepository.save(existingUser);
        return updatedUser.toDTO();
    }

    private String getMessage(String key, Object... args) {
        return messageSource.getMessage(key, args, LocaleContextHolder.getLocale());
    }
}
