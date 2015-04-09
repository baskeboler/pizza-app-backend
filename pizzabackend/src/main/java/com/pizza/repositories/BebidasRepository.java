package com.pizza.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.pizza.models.Bebida;

@RepositoryRestResource(collectionResourceRel="bebidas", path="bebidas")
public interface BebidasRepository extends CrudRepository<Bebida, String>{

}
