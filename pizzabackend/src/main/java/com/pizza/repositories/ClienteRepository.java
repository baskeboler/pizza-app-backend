package com.pizza.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.pizza.models.Cliente;

@RepositoryRestResource(collectionResourceRel="clientes",path="clientes")
public interface ClienteRepository extends MongoRepository<Cliente, String>, ClienteRepositoryCustom{
	List<Cliente> findByEmailLike( @Param(value="email") String email);
	List<Cliente> findByNombreContainingOrDireccionContainingOrTelefonoContaining(@Param(value="valor")String valor);
	

}
