package com.itembox.itembox.business.mapper;

import org.mapstruct.Mapper;

import com.itembox.itembox.persistance.dto.SucursalesDto;
import com.itembox.itembox.persistance.entity.Sucursales;

@Mapper(componentModel = "spring")
public interface SucursalesMapper {
    SucursalesDto toDto(Sucursales sucursales);
    Sucursales toEntity(SucursalesDto sucursalesDto);
}
