package com.hms.User.api;

import com.hms.User.dto.LoginDTO;
import com.hms.User.dto.RegisterRequestDTO;
import com.hms.User.dto.UserResponseDTO;
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

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return new ResponseEntity<>("text", HttpStatus.OK);
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponseDTO> register(@Valid @RequestBody RegisterRequestDTO registerRequestDTO) throws HmException {
        UserResponseDTO registeredUser = userService.register(registerRequestDTO);
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

    @GetMapping("/find/{id}")
    public ResponseEntity<UserResponseDTO> getUser(@PathVariable Long id) throws HmException {
        UserResponseDTO userDTO = userService.findUserById(id);
        return ResponseEntity.ok(userDTO);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<UserResponseDTO> updateUser(@PathVariable Long id, @Valid @RequestBody RegisterRequestDTO registerRequestDTO) throws HmException {
        UserResponseDTO updatedUser = userService.updateUser(id, registerRequestDTO);
        return ResponseEntity.ok(updatedUser);
    }
}
