package br.com.restaurante.microservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.restaurante.microservice.model.Restaurante;
import br.com.restaurante.microservice.service.RestauranteService;

@RestController
@RequestMapping(name = "/restaurante")
public class RestauranteController {

	@Autowired
	private RestauranteService restauranteService;

	public void persitir(Restaurante restaurante) {
		try {
			restauranteService.persitir(restaurante);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
		}
	}

}
