package br.com.restaurante.microservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.restaurante.microservice.model.Pedido;
import br.com.restaurante.microservice.service.PedidoService;

@RestController
@RequestMapping(value = "/pedido")
public class PedidoController {
	
	@Autowired
	private PedidoService pedidoService;
	
	@RequestMapping(value = "persitir", method = RequestMethod.POST)
	public void persitir(@RequestBody Pedido pedido) {
		try {
			pedidoService.persitir(pedido);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}
	
	@RequestMapping(value = "/montagemPedido", method = RequestMethod.POST)
	public void montagemPedido(@RequestBody Pedido pedido) {
		try {
			pedidoService.montagemPedido(pedido);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Pedido> findAll() {
		try {
			return pedidoService.findAll();
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}
}
