package com.pizza.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.pizza.models.Plato;


@RepositoryRestResource(collectionResourceRel="platos", path="platos")
public interface PlatosRepository extends MongoRepository<Plato, String>{

}
