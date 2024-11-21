package com.itembox.itembox.business.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.itembox.itembox.persistance.dto.ArticulosDto;
import com.itembox.itembox.persistance.entity.Articulos;

@Mapper(componentModel = "spring")
public interface ArticulosMapper{
    ArticulosDto toDto(Articulos articulos);

    @Mapping(target = "sucursal", ignore = true)
    Articulos toEntity(ArticulosDto articulosDto);

}
