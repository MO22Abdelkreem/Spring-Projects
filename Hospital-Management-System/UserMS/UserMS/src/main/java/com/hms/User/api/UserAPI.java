package com.hms.User.api;

import com.hms.User.dto.LoginDTO;
import com.hms.User.dto.UserDTO;
import com.hms.User.exception.HmException;
import com.hms.User.jwt.CustomUserDetails;
import com.hms.User.jwt.JwtUtil;
import com.hms.User.jwt.MyUserDetailsService;
import com.hms.User.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
@CrossOrigin
public class UserAPI {

    private final UserService userService;
    private final JwtUtil jwtUtil;
    private final MyUserDetailsService myUserDetailsService;

    @PostMapping("/register")
    public ResponseEntity<UserDTO> register(@Valid @RequestBody UserDTO userDTO) throws HmException {
        UserDTO registeredUser = userService.register(userDTO);
        return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginDTO> login(@RequestBody LoginDTO loginRequest) throws HmException {
        userService.login(loginRequest.getEmail(), loginRequest.getPassword());
        CustomUserDetails userDetails = (CustomUserDetails) myUserDetailsService.loadUserByUsername(loginRequest.getEmail());
        loginRequest.setToken(jwtUtil.generateToken(userDetails));
        loginRequest.setPassword(null);
        return ResponseEntity.ok(loginRequest);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long id) throws HmException {
        UserDTO userDTO = userService.findUserById(id);
        return ResponseEntity.ok(userDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @Valid @RequestBody UserDTO userDTO) throws HmException {
        UserDTO updatedUser = userService.updateUser(id, userDTO);
        return ResponseEntity.ok(updatedUser);
    }
}
