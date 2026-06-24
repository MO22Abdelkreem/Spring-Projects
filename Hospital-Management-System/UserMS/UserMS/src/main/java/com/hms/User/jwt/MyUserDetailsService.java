package com.hms.User.jwt;

import com.hms.User.dto.UserDTO;
import com.hms.User.exception.HmException;
import com.hms.User.service.UserService;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserService userService;

    public MyUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            UserDTO userDTO = userService.getUser(username);
            CustomUserDetails userDetails = new CustomUserDetails();
            userDetails.setId(userDTO.getId());
            userDetails.setUsername(userDTO.getEmail());
            userDetails.setPassword(userDTO.getPassword());
            userDetails.setRole(userDTO.getRole());
            userDetails.setName(userDTO.getUsername());
            Collection<SimpleGrantedAuthority> authorities = userDTO.getRole() == null
                    ? Collections.emptyList()
                    : Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + userDTO.getRole().name()));
            userDetails.setGrantedAuthorities(authorities);
            return userDetails;
        } catch (HmException exception) {
            throw new UsernameNotFoundException("User not found with email: " + username, exception);
        }
    }
}
