package com.itembox.itembox.business.mapper;

import org.mapstruct.Mapper;

import com.itembox.itembox.persistance.dto.EmpresaDto;
import com.itembox.itembox.persistance.entity.Empresas;

@Mapper(componentModel = "spring")
public interface EmpresaMapper {
    EmpresaDto toDto (Empresas empresa);
    Empresas toEntity (EmpresaDto empresaDto);
}
