package com.pizza.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

import com.pizza.models.Plato;

@RepositoryRestResource(collectionResourceRel="platos", path="platos")
public interface PlatosRepository extends CrudRepository<Plato, String>{

}
