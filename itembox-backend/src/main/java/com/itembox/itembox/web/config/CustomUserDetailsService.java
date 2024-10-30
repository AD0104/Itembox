package com.itembox.itembox.web.config;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.itembox.itembox.persistance.dao.IUsuarioRepository;
import com.itembox.itembox.persistance.entity.Usuario;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private IUsuarioRepository iUsuarioRepository;
    private static final Logger logger = LoggerFactory.getLogger(CustomUserDetailsService.class);

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        Optional<Usuario> optionalUsuario = this.iUsuarioRepository.findFirstByEmail(userEmail);
        if (!optionalUsuario.isPresent()) {
            logger.error("Error, no user registered with email: {}", userEmail);
            throw new UsernameNotFoundException("No hay un usuario registrado con el email proporcionado");
        }
        Usuario usuario = optionalUsuario.get();
        Set<GrantedAuthority> authorities = new HashSet<>();
        usuario.getRoles().forEach(rol -> authorities.add(new SimpleGrantedAuthority(rol.getRol())));

        return new User( userEmail, usuario.getPassword(), authorities);
    }
}
