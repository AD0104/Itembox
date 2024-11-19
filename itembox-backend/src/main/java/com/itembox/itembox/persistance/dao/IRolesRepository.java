package com.itembox.itembox.persistance.dao;

import org.springframework.data.repository.CrudRepository;

import com.itembox.itembox.persistance.entity.Roles;

public interface IRolesRepository extends CrudRepository<Roles, Integer> {
    Roles findFirstByRol(String rol);
}
