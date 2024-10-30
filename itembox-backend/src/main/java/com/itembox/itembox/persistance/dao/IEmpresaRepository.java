package com.itembox.itembox.persistance.dao;

import org.springframework.data.repository.CrudRepository;

import com.itembox.itembox.persistance.entity.Empresas;

public interface IEmpresaRepository extends CrudRepository<Empresas, Integer> {
}
