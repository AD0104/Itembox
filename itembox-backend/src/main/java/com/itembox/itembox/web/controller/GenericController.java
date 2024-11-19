package com.itembox.itembox.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import com.itembox.itembox.persistance.dto.http.AuthGenericResponse;

@RestController
public class GenericController {
    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<AuthGenericResponse> badCredentialsExceptionHandler(BadCredentialsException badCredentialsException) {
        AuthGenericResponse response = new AuthGenericResponse();
        response.setCode(400);
        response.setMessage("Email or password incorrect");
        response.setData(null);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
