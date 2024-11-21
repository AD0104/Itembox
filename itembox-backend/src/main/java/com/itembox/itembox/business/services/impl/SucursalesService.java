package com.itembox.itembox.business.services.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itembox.itembox.business.mapper.SucursalesMapper;
import com.itembox.itembox.business.services.ISucursalesService;
import com.itembox.itembox.persistance.dao.ISucursalesRepository;
import com.itembox.itembox.persistance.dto.SucursalesDto;


@Service
public class SucursalesService implements ISucursalesService {
    @Autowired
    private ISucursalesRepository sRepository;

    @Autowired
    private SucursalesMapper sMapper;
    
    public static final Logger logger = LoggerFactory.getLogger(SucursalesService.class);

    @Override
    public List<SucursalesDto> getListSucursales() {
        this.sRepository.findAll().forEach(i -> {
            logger.info("Sucursal: {}", i.toString());
            logger.info("SucursalDto: {}", sMapper.toDto(i).toString() );
        });
        return null;
    }

    @Override
    public SucursalesDto getSucursal(String idSucursalExterno) {
        return null;
    }
}
