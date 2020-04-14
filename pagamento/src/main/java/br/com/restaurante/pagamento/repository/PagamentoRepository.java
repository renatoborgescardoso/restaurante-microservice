package br.com.restaurante.pagamento.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.restaurante.pagamento.model.Pagamento;

@Repository
public interface PagamentoRepository extends CrudRepository<Pagamento, Long> {

}
