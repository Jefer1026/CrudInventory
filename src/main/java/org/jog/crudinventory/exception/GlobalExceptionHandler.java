package org.jog.crudinventory.exception;


import jakarta.servlet.http.HttpServletRequest;
import org.jog.crudinventory.dto.ApiErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> genericExceptionHandler(Exception exception, HttpServletRequest request) {

        ApiErrorDTO apiErrorDTO = new ApiErrorDTO();
        apiErrorDTO.setBackendMessage(exception.getLocalizedMessage());
        apiErrorDTO.setMessage("Internal Server Error");
        apiErrorDTO.setMethod(request.getMethod());
        apiErrorDTO.setURL(request.getRequestURL().toString());
        apiErrorDTO.setTimeStamp(LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiErrorDTO);

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> MethodArgumentNotValidException(MethodArgumentNotValidException exception, HttpServletRequest request) {
        ApiErrorDTO apiErrorDTO = new ApiErrorDTO();
        apiErrorDTO.setBackendMessage(exception.getLocalizedMessage());
        apiErrorDTO.setBackendMessage("Request body is invalid");
        apiErrorDTO.setMethod(request.getMethod());
        apiErrorDTO.setURL(request.getRequestURL().toString());
        apiErrorDTO.setTimeStamp(LocalDateTime.now());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiErrorDTO);

    }
}
