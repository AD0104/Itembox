package com.itembox.itembox.business.services;

import com.itembox.itembox.persistance.dto.EmpresaDto;
import com.itembox.itembox.persistance.dto.SucursalesDto;
import com.itembox.itembox.persistance.dto.http.GenericResponse;

public interface IEmpresaService {
    
    GenericResponse saveEnterprise(EmpresaDto empresaDto);

    EmpresaDto getEnterpriseById(Integer id);
    
    EmpresaDto postRegisterLocation(Integer id, SucursalesDto sucursalesDto);
}
