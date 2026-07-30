package com.hms.User.service;

import com.hms.User.dto.RegisterRequestDTO;
import com.hms.User.dto.UserDTO;
import com.hms.User.dto.UserResponseDTO;
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
    public UserResponseDTO register(RegisterRequestDTO registerRequestDTO) throws HmException {
        if (userRepository.findByUsername(registerRequestDTO.getUsername()).isPresent()) {
            throw new HmException(getMessage("user.username.exists"));
        }
        Optional<User> optionalUser = userRepository.findByEmail(registerRequestDTO.getEmail());
        if (optionalUser.isPresent()) {
            throw new HmException(getMessage("user.email.exists"));
        }
        User user = registerRequestDTO.toEntity();
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        Long profileId;
        try {
            profileId = apiService.addProfile(registerRequestDTO).block();
        } catch (org.springframework.web.reactive.function.client.WebClientResponseException exception) {
            throw new HmException("Profile service error: " + exception.getResponseBodyAsString(), exception);
        } catch (RuntimeException exception) {
            throw new HmException("Unable to create profile. Error: " + exception.getMessage(), exception);
        }
        user.setProfileId(profileId);
        User savedUser = userRepository.save(user);
        return savedUser.toResponseDTO();
    }


    @Override
    public UserResponseDTO login(String email, String password) throws HmException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new HmException(getMessage("user.login.invalid")));
        
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new HmException(getMessage("user.login.invalid"));
        }
        return user.toResponseDTO();
    }

    @Override
    public UserResponseDTO findUserById(Long id) throws HmException {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new HmException(getMessage("user.not.found", id)));
        return user.toResponseDTO();
    }

    @Override
    public UserResponseDTO getUser(Long id) throws HmException {
        return findUserById(id);
    }

    @Override
    public UserDTO getUser(String email) throws HmException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new HmException(getMessage("user.not.found")));
        return user.toDTO();
    }

    @Override
    public UserResponseDTO updateUser(Long id, RegisterRequestDTO registerRequestDTO) throws HmException {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new HmException(getMessage("user.not.found", id)));
        
        existingUser.setUsername(registerRequestDTO.getUsername());
        existingUser.setEmail(registerRequestDTO.getEmail());
        existingUser.setPassword(passwordEncoder.encode(registerRequestDTO.getPassword()));
        existingUser.setRole(registerRequestDTO.getRole());

        User updatedUser = userRepository.save(existingUser);
        return updatedUser.toResponseDTO();
    }

    private String getMessage(String key, Object... args) {
        return messageSource.getMessage(key, args, LocaleContextHolder.getLocale());
    }
}
