package br.com.restaurante.microservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.restaurante.microservice.model.TipoComida;
import br.com.restaurante.microservice.service.TipoComidaService;

@RestController
@RequestMapping(value = "/tipocomida")
public class TipoComidaController {

	@Autowired
	private TipoComidaService tipoComidaService;
	
	@RequestMapping(method = RequestMethod.POST)
	public void persitir(@RequestBody TipoComida tipoComida) {
		try {
			tipoComidaService.persitir(tipoComida);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<TipoComida> findAll() {
		try {
			return tipoComidaService.findAll();
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}

}
