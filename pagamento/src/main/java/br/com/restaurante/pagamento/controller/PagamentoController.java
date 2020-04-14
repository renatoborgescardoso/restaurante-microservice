package br.com.restaurante.pagamento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.restaurante.pagamento.model.Pagamento;
import br.com.restaurante.pagamento.service.PagamentoService;

@RestController
@RequestMapping(value = "/pedido")
public class PagamentoController {
	
	@Autowired
	private PagamentoService pagamentoService;
	
	@RequestMapping(method = RequestMethod.POST)
	public void persitir(@RequestBody Pagamento pagamento) {
		try {
			pagamentoService.persitir(pagamento);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}

	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public List<Pagamento> findAll() {
		try {
			return pagamentoService.findAll();
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}
}
