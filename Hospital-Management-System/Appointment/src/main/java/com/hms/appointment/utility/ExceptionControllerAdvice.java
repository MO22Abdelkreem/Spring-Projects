package com.hms.appointment.utility;

import com.hms.appointment.exception.HmException;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import feign.FeignException;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorInfo> exceptionHandler(Exception exception) {
        exception.printStackTrace();
        ErrorInfo errorInfo = new ErrorInfo(
                exception.getMessage() != null ? exception.getMessage() : "Some Error Occurred",
                (long) HttpStatus.INTERNAL_SERVER_ERROR.value(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(errorInfo, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(FeignException.class)
    public ResponseEntity<ErrorInfo> handleFeignException(FeignException exception) {
        exception.printStackTrace();
        HttpStatus status = HttpStatus.resolve(exception.status());
        if (status == null) {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        String errorMsg = exception.contentUTF8();
        if (errorMsg == null || errorMsg.isBlank()) {
            errorMsg = exception.getMessage();
        }
        ErrorInfo errorInfo = new ErrorInfo(
                errorMsg,
                (long) status.value(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(errorInfo, status);
    }

    @ExceptionHandler(HmException.class)
    public ResponseEntity<ErrorInfo> exceptionHandler(HmException exception) {
        ErrorInfo errorInfo = new ErrorInfo(
                exception.getMessage(),
                (long) HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({
            MethodArgumentNotValidException.class,
            ConstraintViolationException.class
    })
    public ResponseEntity<ErrorInfo> handleValidationExceptions(Exception e) {
        String errorMsg;

        if (e instanceof MethodArgumentNotValidException manv) {
            errorMsg = manv.getBindingResult()
                    .getAllErrors()
                    .stream()
                    .map(ObjectError::getDefaultMessage)
                    .collect(Collectors.joining(","));
        } else {
            ConstraintViolationException cve = (ConstraintViolationException) e;

            errorMsg = cve.getConstraintViolations()
                    .stream()
                    .map(ConstraintViolation::getMessage)
                    .collect(Collectors.joining(","));
        }

        ErrorInfo error = new ErrorInfo(
                errorMsg,
                (long) HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now()
        );

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
