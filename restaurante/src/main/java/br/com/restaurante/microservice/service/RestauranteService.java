package br.com.restaurante.microservice.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.restaurante.microservice.model.Restaurante;

@Service
public class RestauranteService {

	private static final Logger logger = LogManager.getLogger(RestauranteService.class);
	
	@Autowired
	private RestauranteService restauranteService;
	
	public void persitir(Restaurante restaurante) throws Exception {
		try {
			restauranteService.persitir(restaurante);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new Exception("Houve um erro ao persitir o restaurante.");
		}
	}
}
