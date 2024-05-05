package org.jog.crudinventory.exception;


import jakarta.servlet.http.HttpServletRequest;
import org.jog.crudinventory.dto.ApiErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice

public class GlobalExceptionHandler {


    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handlerGenericException(Exception exception, HttpServletRequest request) {

        ApiErrorDTO apiErrorDTO = new ApiErrorDTO();

        apiErrorDTO.setBackendMessage(exception.getLocalizedMessage());
        apiErrorDTO.setUrl(request.getRequestURL().toString());
        apiErrorDTO.setMethod(request.getMethod());
        apiErrorDTO.setTimestamp(LocalDateTime.now());
        apiErrorDTO.setMessage("Internal Server Error, try again later");

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiErrorDTO);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<?> handlerAccessDeniedException(AccessDeniedException exception, HttpServletRequest request) {
        ApiErrorDTO apiErrorDTO = new ApiErrorDTO();
        apiErrorDTO.setBackendMessage(exception.getLocalizedMessage());
        apiErrorDTO.setUrl(request.getRequestURL().toString());
        apiErrorDTO.setMethod(request.getMethod());
        apiErrorDTO.setTimestamp(LocalDateTime.now());

        apiErrorDTO.setMessage("Access Denied, you don't have permission to access this resource");

        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(apiErrorDTO);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handlerMethodArgumentNotValidException(MethodArgumentNotValidException exception, HttpServletRequest request) {

        ApiErrorDTO apiErrorDTO = new ApiErrorDTO();
        apiErrorDTO.setBackendMessage(exception.getLocalizedMessage());
        apiErrorDTO.setUrl(request.getRequestURL().toString());
        apiErrorDTO.setMethod(request.getMethod());
        apiErrorDTO.setTimestamp(LocalDateTime.now());
        apiErrorDTO.setMessage("Validation Failed");

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(apiErrorDTO);
    }
}
