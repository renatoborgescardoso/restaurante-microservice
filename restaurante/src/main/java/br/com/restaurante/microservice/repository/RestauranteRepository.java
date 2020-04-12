package br.com.restaurante.microservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.restaurante.microservice.model.Restaurante;

@Repository
public interface RestauranteRepository extends CrudRepository<Restaurante, Long> {

}
