package com.hms.User.utility;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorInfo {

    private String errorMessage;
    private Long errorCode;
    private LocalDateTime timestamp;
}
