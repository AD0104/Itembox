package com.itembox.itembox.business.services.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.itembox.itembox.business.mapper.RolesMapper;
import com.itembox.itembox.business.mapper.UsuariosMapper;
import com.itembox.itembox.business.services.IUsuarioService;
import com.itembox.itembox.persistance.dao.IRolesRepository;
import com.itembox.itembox.persistance.dao.IUsuarioRepository;
import com.itembox.itembox.persistance.dto.RolesDto;
import com.itembox.itembox.persistance.dto.UsuarioDto;
import com.itembox.itembox.persistance.dto.http.GenericResponse;
import com.itembox.itembox.persistance.entity.Roles;
import com.itembox.itembox.persistance.entity.Usuario;

@Service
public class UsuarioService implements IUsuarioService{
    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Autowired
    private IRolesRepository rolesRepository;

    @Autowired
    private UsuariosMapper uMapper;
    
    @Autowired
    private RolesMapper rMapper;

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
        usuario.setRoles(null);

        if (usuarioDto.getRoles() != null) {
            List<Roles> listRoles = new ArrayList<>();
            for(RolesDto rolesDto : usuarioDto.getRoles()) {
                Roles role = this.rolesRepository.findFirstByRol(rolesDto.getRol());
                if (role != null) {
                    listRoles.add(role);
                } else {
                    role = this.rMapper.toEntity(rolesDto);
                    listRoles.add(role);
                }
            }
            usuario.setRoles(listRoles);
        } else {
            Roles role = new Roles();
            role.setRol("USER");
            usuario.setRoles(Collections.singletonList(role) );
        }

        try {
            this.usuarioRepository.save(usuario);
        } catch (Exception e) {
            logger.error("Error al intentar registrar un usuario: {}", e.getMessage());
            return null;
        }
        return new GenericResponse("Usuario registrado correctamente", 200);
            
    }
}
