package br.com.restaurante.pagamento.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.restaurante.pagamento.model.Pagamento;
import br.com.restaurante.pagamento.repository.PagamentoRepository;

@Service
public class PagamentoService {

private static final Logger logger = LogManager.getLogger(PagamentoService.class);
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	public void persitir(Pagamento pagamento) throws Exception {
		try {
			pagamentoRepository.save(pagamento);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new Exception("Houve um erro ao gravar o pagamento.");
		}
	}
	
	public List<Pagamento> findAll() throws Exception {
		try {
			return (List<Pagamento>) pagamentoRepository.findAll();
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new Exception("Houve um erro ao consultar os os pagamentos.");
		}
	}
}
