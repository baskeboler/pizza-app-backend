package com.pizza.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.pizza.models.Cliente;

@RepositoryRestResource(collectionResourceRel="clientes", path="clientes")
public interface ClienteRepository extends MongoRepository<Cliente, String>{
	Cliente findByEmail(String email);

}
