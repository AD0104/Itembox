package com.itembox.itembox.web.controller;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.itembox.itembox.business.services.IAuthService;
import com.itembox.itembox.business.services.IUsuarioService;
import com.itembox.itembox.persistance.dto.AuthLoginDto;
import com.itembox.itembox.persistance.dto.AuthLoginResponseDto;
import com.itembox.itembox.persistance.dto.UsuarioDto;
import com.itembox.itembox.persistance.dto.http.AuthGenericResponse;
import com.itembox.itembox.persistance.dto.http.GenericResponse;

@RestController
@RequestMapping(value = "/api/auth")
public class AuthController extends GenericController{

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    private IAuthService authService;

    @Autowired IUsuarioService usuarioService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<AuthGenericResponse> postLogin(@RequestBody AuthLoginDto loginDto) {
        logger.info("[AuthController.postLogin] Ini Call, Process Date: {}", LocalDate.now());

        String authToken = authService.login(loginDto);

        AuthGenericResponse response = new AuthGenericResponse();
        response.setMessage("Ok");
        response.setCode(200);
        response.setData(new AuthLoginResponseDto(authToken, "Bearer "));

        logger.info("[AuthController.postLogin] Fin Call, Process Date: {}", LocalDate.now());
        return ResponseEntity.ok() .body(response);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public ResponseEntity<String> getLogout() {
        return new ResponseEntity<>("Logout Ok", HttpStatus.OK);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<GenericResponse> postRegister (@RequestBody UsuarioDto usuarioDto) {
        logger.info("[AuthController.postRegister] Ini Call, Process Date: {}", LocalDate.now());

        if (usuarioService.isUserRegistered(usuarioDto.getEmail()))
            return new ResponseEntity<GenericResponse>(new GenericResponse("Usuario no disponible", 400), HttpStatus.OK);

        GenericResponse response = this.usuarioService.registerUser(usuarioDto);

        logger.info("[AuthController.postRegister] Ini Call, Process Date: {}", LocalDate.now());
        return new ResponseEntity<GenericResponse>(response, HttpStatus.OK);
    }
}
