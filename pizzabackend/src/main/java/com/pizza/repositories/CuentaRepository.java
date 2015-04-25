package com.pizza.repositories;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.access.prepost.PreAuthorize;

import com.pizza.models.Cuenta;

public interface CuentaRepository extends MongoRepository<Cuenta, String> {
	Optional<Cuenta> findByUsuario(String usuario);
}
