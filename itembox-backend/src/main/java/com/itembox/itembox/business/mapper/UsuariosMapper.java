package com.itembox.itembox.business.mapper;

import org.mapstruct.Mapper;

import com.itembox.itembox.persistance.dto.UsuarioDto;
import com.itembox.itembox.persistance.entity.Usuario;

@Mapper(componentModel = "spring")
public interface UsuariosMapper {
    UsuarioDto toDto(Usuario usuario);
    Usuario toEntity(UsuarioDto usuarioDto);
}
