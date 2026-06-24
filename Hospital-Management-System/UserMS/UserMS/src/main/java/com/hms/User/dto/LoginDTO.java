package com.hms.User.dto;

import lombok.Data;

@Data
public class LoginDTO {

    private String email;
    private String password;
    private String token;
}
