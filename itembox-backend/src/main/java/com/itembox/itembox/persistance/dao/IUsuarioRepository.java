package com.itembox.itembox.persistance.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.itembox.itembox.persistance.entity.Usuario;

public interface IUsuarioRepository extends CrudRepository<Usuario, Integer> {
    List<Usuario> findByEmail(String email);
    List<Usuario> findByUserNameOrEmail(String userName, String email);
    Optional<Usuario> findFirstByEmail(String email);
    Optional<Usuario> findFirstByUserName(String userName);
}
