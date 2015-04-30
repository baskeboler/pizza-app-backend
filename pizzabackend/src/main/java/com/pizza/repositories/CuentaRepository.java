package com.pizza.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.pizza.models.Cuenta;

public interface CuentaRepository extends CrudRepository<Cuenta, String> {
	Optional<Cuenta> findByUsuario(String usuario);
}
