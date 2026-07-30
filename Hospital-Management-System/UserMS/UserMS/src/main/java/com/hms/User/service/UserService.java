package com.hms.User.service;

import com.hms.User.dto.RegisterRequestDTO;
import com.hms.User.dto.UserDTO;
import com.hms.User.dto.UserResponseDTO;
import com.hms.User.exception.HmException;

public interface UserService {
    UserResponseDTO register(RegisterRequestDTO registerRequestDTO) throws HmException;
    UserResponseDTO login(String email, String password) throws HmException;
    UserResponseDTO findUserById(Long id) throws HmException;
    UserResponseDTO getUser(Long id) throws HmException;
    UserDTO getUser(String email) throws HmException;
    UserResponseDTO updateUser(Long id, RegisterRequestDTO registerRequestDTO) throws HmException;
}
