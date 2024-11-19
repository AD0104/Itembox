package com.itembox.itembox.business.services.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itembox.itembox.business.mapper.EmpresaMapper;
import com.itembox.itembox.business.mapper.SucursalesMapper;
import com.itembox.itembox.business.services.IEmpresaService;
import com.itembox.itembox.persistance.dao.IEmpresaRepository;
import com.itembox.itembox.persistance.dao.ISucursalesRepository;
import com.itembox.itembox.persistance.dto.EmpresaDto;
import com.itembox.itembox.persistance.dto.SucursalesDto;
import com.itembox.itembox.persistance.dto.http.GenericResponse;
import com.itembox.itembox.persistance.entity.Empresas;
import com.itembox.itembox.persistance.entity.Sucursales;

@Service
public class EmpresaService implements IEmpresaService{

    private static final Logger logger = LoggerFactory.getLogger(EmpresaService.class);

    @Autowired
    private IEmpresaRepository eRepository;

    @Autowired
    private ISucursalesRepository sRepository;

    @Autowired
    private EmpresaMapper eMapper;

    @Autowired
    private SucursalesMapper sMapper;
    
    @Override
    public GenericResponse saveEnterprise(EmpresaDto empresaDto) {
        List<SucursalesDto> sucursalesList = empresaDto.getSucursales();
        empresaDto.setSucursales(null);
        Empresas empresa = eMapper.toEntity(empresaDto);

        try {
            eRepository.save(empresa);
            for (SucursalesDto sucursal : sucursalesList) {
                sucursal.setEmpresa(eMapper.toDto(empresa));
                this.sRepository.save(sMapper.toEntity(sucursal));
            }
        } catch (Exception e) {
            logger.error("Error while saving enterprise entity: {}", e.getMessage());
            return new GenericResponse(e.getMessage(), 400);
        }
        return new GenericResponse("Ok", 200);
    }

    @Override
    public EmpresaDto getEnterpriseById(Integer id) {
        return this.eMapper.toDto(this.eRepository.findById(id).get());
    }

    @Override
    public EmpresaDto postRegisterLocation(Integer id, SucursalesDto sucursalesDto) {
        Optional<Empresas> optionalEmpresa = this.eRepository.findById(id);
        if ( optionalEmpresa.isEmpty() ) {
            logger.warn("Warning, trying to query for an enterprise id non existant, id: {}", id);
            return null;
        }
        Sucursales sucursal = sMapper.toEntity(sucursalesDto);
        sucursal.setEmpresa(optionalEmpresa.get());

        try {
            this.sRepository.save(sucursal);
        } catch (Exception e) {
            logger.error("Error while saving a location entity: {}", e.getMessage());
            return null;
        }

        List<Sucursales> sucursalesList = optionalEmpresa.get().getSucursales();
        sucursalesList.add(sucursal);
        optionalEmpresa.get().setSucursales( sucursalesList );
        try {
            this.eRepository.save(optionalEmpresa.get());
        } catch (Exception e) {
            logger.error("Error while updating an enterprise entity: {}", e.getMessage());
            return null;
        }

        return eMapper.toDto(optionalEmpresa.get());
    }
}
