package com.pizza.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.pizza.models.Pedido;

@RepositoryRestResource(collectionResourceRel="pedidos", path="pedidos")
public interface PedidosRepository extends MongoRepository<Pedido, String>{

}
