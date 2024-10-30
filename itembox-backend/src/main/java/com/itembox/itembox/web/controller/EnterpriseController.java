package com.itembox.itembox.web.controller;

import java.time.LocalDate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.itembox.itembox.business.services.IEmpresaService;
import com.itembox.itembox.persistance.dto.EmpresaDto;
import com.itembox.itembox.persistance.dto.SucursalesDto;
import com.itembox.itembox.persistance.dto.http.GenericResponse;

@RestController
@RequestMapping(value = "/api/enterpise")
public class EnterpriseController {

    private static final Logger logger = LoggerFactory.getLogger(EnterpriseController.class);

    @Autowired
    private IEmpresaService empresaService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<EmpresaDto> getEnterpriseInformation(@PathVariable("id") Integer id) {
        logger.info("[EnterpriseController.getEnterpriseInformation] Ini Call. Process Date: {}", LocalDate.now());

        EmpresaDto response = this.empresaService.getEnterpriseById(id);
        Integer statusCode = response == null ? 400 : 200;

        logger.info("[EnterpriseController.getEnterpriseInformation] Fin Call. Process Date: {}", LocalDate.now());
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(statusCode));
    }

    @RequestMapping(value = "/{id}/register/location", method = RequestMethod.POST)
    public ResponseEntity<EmpresaDto> postEnterpriseLocation(@PathVariable("id") Integer id, @RequestBody SucursalesDto sucursalesDto) {
        logger.info("[EnterpriseController.postEnterpriseLocation] Ini Call. Process Date: {}", LocalDate.now());
        EmpresaDto response = this.empresaService.postRegisterLocation(id, sucursalesDto);
        if (response == null) 
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        logger.info("[EnterpriseController.postEnterpriseLocation] Fin Call. Process Date: {}", LocalDate.now());
        return new ResponseEntity<>(response, HttpStatus.OK);

    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<GenericResponse> postRegisterEnterprise(@RequestBody EmpresaDto empresaDto) {
        logger.info("[EnterpriseController.postRegisterEnterprise] Ini Call. Process Date: {}", LocalDate.now());

        GenericResponse response = this.empresaService.saveEnterprise(empresaDto);

        logger.info("[EnterpriseController.postRegisterEnterprise] Fin Call. Process Date: {}", LocalDate.now());
        return new ResponseEntity<>(response, HttpStatusCode.valueOf(response.getCode()));
    }
}
