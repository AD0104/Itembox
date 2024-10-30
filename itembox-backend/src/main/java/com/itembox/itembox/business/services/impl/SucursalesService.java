package com.itembox.itembox.business.services.impl;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<SucursalesDto> getListSucursales() {
        List<SucursalesDto> response = new ArrayList<SucursalesDto>();
        this.sRepository.findAll().forEach( i -> response.add( sMapper.toDto(i) ) );
        return response;
    }
}
