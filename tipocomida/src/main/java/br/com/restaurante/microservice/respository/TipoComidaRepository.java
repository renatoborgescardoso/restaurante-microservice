package br.com.restaurante.microservice.respository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.restaurante.microservice.model.TipoComida;

@Repository
public interface TipoComidaRepository extends CrudRepository<TipoComida, Long> {

}
