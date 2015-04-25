package com.pizza.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;

import com.pizza.models.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, String>{
	List<Cliente> findByEmailLike( @Param(value="email") String email);

}
