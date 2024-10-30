package com.itembox.itembox.business.services;

import com.itembox.itembox.persistance.dto.UsuarioDto;
import com.itembox.itembox.persistance.dto.http.GenericResponse;

public interface IUsuarioService {

    boolean isUserRegistered(String userName);
    
    GenericResponse registerUser( UsuarioDto usuarioDto);
}
