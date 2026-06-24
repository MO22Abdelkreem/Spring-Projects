package com.hms.User.service;

import com.hms.User.dto.UserDTO;
import com.hms.User.exception.HmException;

public interface UserService {
    UserDTO register(UserDTO userDTO) throws HmException;
    UserDTO login(String email, String password) throws HmException;
    UserDTO findUserById(Long id) throws HmException;
    UserDTO getUser(Long id) throws HmException;
    UserDTO getUser(String email) throws HmException;
    UserDTO updateUser(Long id, UserDTO userDTO) throws HmException;
}
