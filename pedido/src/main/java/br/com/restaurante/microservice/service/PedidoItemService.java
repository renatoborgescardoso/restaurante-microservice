package br.com.restaurante.microservice.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.restaurante.microservice.model.PedidoItem;
import br.com.restaurante.microservice.repository.PedidoItemRepository;

@Service
public class PedidoItemService {

	private static final Logger logger = LogManager.getLogger(PedidoItemService.class);

	@Autowired
	private PedidoItemRepository pedidoItemRepository;
	
	public void persitir(PedidoItem pedidoItem) throws Exception {
		try {
			pedidoItemRepository.save(pedidoItem);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new Exception("Houve um erro ao persitir o pedido.");
		}
	}

	public List<PedidoItem> findAll() throws Exception {
		try {
			return (List<PedidoItem>) pedidoItemRepository.findAll();
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new Exception("Houve um erro ao consultar os pedidos.");
		}
	}

	public PedidoItem findById(Long id) throws Exception {
		try {
			return pedidoItemRepository.findById(id).orElse(new PedidoItem());
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new Exception("Houve um erro ao consultar os pedidos.");
		}
	}
}
