package com.itembox.itembox.web.controller;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itembox.itembox.business.services.ISucursalesService;
import com.itembox.itembox.persistance.dto.SucursalesDto;

@RestController
@RequestMapping(value = "/api/sucursal")
public class SucursalesController {

    @Autowired
    private ISucursalesService iSucursalesService;

    private static final Logger logger = LoggerFactory.getLogger(SucursalesController.class);
    
    public ResponseEntity<List<SucursalesDto>> getListSucursales() {
        logger.info("[SucursalesController.getListSucursales] Ini Call, Process Date: {}", LocalDate.now());

        List<SucursalesDto> response = this.iSucursalesService.getListSucursales();

        logger.info("[SucursalesController.getListSucursales] Fin Call, Process Date: {}", LocalDate.now());

        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
