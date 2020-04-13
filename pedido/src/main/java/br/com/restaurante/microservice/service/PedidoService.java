package br.com.restaurante.microservice.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.restaurante.microservice.model.Pedido;
import br.com.restaurante.microservice.model.SituacaoPedidoEnum;
import br.com.restaurante.microservice.repository.PedidoRepository;

@Service
public class PedidoService {
	
	private static final Logger logger = LogManager.getLogger(PedidoService.class);

	@Autowired
	private PedidoRepository pedidoRepository;
	
	public void persitir(Pedido pedido) throws Exception {
		try {
			pedido.setSituacao(SituacaoPedidoEnum.AGUARDANDO_APROVACAO);
			pedidoRepository.save(pedido);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new Exception("Houve um erro ao persitir o pedido.");
		}
	}

	public List<Pedido> findAll() throws Exception {
		try {
			return (List<Pedido>) pedidoRepository.findAll();
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new Exception("Houve um erro ao consultar os pedidos.");
		}
	}

	public Pedido findById(Long id) throws Exception {
		try {
			return pedidoRepository.findById(id).orElse(new Pedido());
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new Exception("Houve um erro ao consultar os pedidos.");
		}
	}
}
