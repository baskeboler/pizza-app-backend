package com.pizza.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.pizza.models.Cuenta;

public interface CuentaRepository extends MongoRepository<Cuenta, String> {
	Optional<Cuenta> findByUsuario(String usuario);
}
