package com.itembox.itembox.business.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.itembox.itembox.business.mapper.UsuariosMapper;
import com.itembox.itembox.business.services.IUsuarioService;
import com.itembox.itembox.persistance.dao.IUsuarioRepository;
import com.itembox.itembox.persistance.dto.UsuarioDto;
import com.itembox.itembox.persistance.dto.http.GenericResponse;
import com.itembox.itembox.persistance.entity.Usuario;

@Service
public class UsuarioService implements IUsuarioService{
    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Autowired
    private UsuariosMapper uMapper;

    private static final Logger logger = LoggerFactory.getLogger(UsuarioService.class);

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public boolean isUserRegistered(String userName) {
        return this.usuarioRepository.findFirstByEmail(userName).isPresent();
    }

    @Override
    public GenericResponse registerUser( UsuarioDto usuarioDto) {
        usuarioDto.setPassword(passwordEncoder.encode(usuarioDto.getPassword()));
        Usuario usuario = uMapper.toEntity(usuarioDto);

        try {
            this.usuarioRepository.save(usuario);
        } catch (Exception e) {
            logger.error("Error al intentar registrar un usuario: {}", e.getMessage());
            return null;
        }
        return new GenericResponse("Usuario registrado correctamente", 200);
            
    }
}
