package com.itembox.itembox.business.mapper;

import org.mapstruct.Mapper;

import com.itembox.itembox.persistance.dto.RolesDto;
import com.itembox.itembox.persistance.entity.Roles;

@Mapper(componentModel = "spring")
public interface RolesMapper {
    RolesDto toDto(Roles role);
    Roles toEntity(RolesDto rolesDto);
}
