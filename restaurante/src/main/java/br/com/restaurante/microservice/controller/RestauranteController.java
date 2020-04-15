package br.com.restaurante.microservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.restaurante.microservice.model.Restaurante;
import br.com.restaurante.microservice.service.RestauranteService;

@RestController
@RequestMapping(value = "/restaurante")
public class RestauranteController {

	@Autowired
	private RestauranteService restauranteService;

	@RequestMapping(method = RequestMethod.POST)
	public void persitir(@RequestBody Restaurante restaurante) {
		try {
			restauranteService.persitir(restaurante);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Restaurante> findAll() {
		try {
			return restauranteService.findAll();
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}

}
