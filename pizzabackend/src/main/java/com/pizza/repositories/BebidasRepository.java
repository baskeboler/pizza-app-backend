package com.pizza.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.pizza.models.Bebida;

@RepositoryRestResource(collectionResourceRel="bebidas", path="bebidas")
public interface BebidasRepository extends MongoRepository<Bebida, String>{

}
