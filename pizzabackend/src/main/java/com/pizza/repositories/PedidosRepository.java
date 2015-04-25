package com.pizza.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.prepost.PreAuthorize;

import com.pizza.models.Pedido;

@RepositoryRestResource(collectionResourceRel = "pedidos", path = "pedidos")
public interface PedidosRepository extends MongoRepository<Pedido, String> {
	List<Pedido> findByFechaBetween(@Param(value = "fecha1") Date fechaStart,
			@Param(value = "fecha2") Date fechaEnd);

	List<Pedido> findByFecha(@Param(value = "fecha") Date fecha);
	@Query("{'estado.estado': {'$ne': 'ENTREGADO' }}")
	List<Pedido> obtenerPedidosPendientes();

}
