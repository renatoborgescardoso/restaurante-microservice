package br.com.restaurante.microservice.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.restaurante.microservice.model.Restaurante;
import br.com.restaurante.microservice.repository.RestauranteRepository;

@Service
public class RestauranteService {

	private static final Logger logger = LogManager.getLogger(RestauranteService.class);
	
	@Autowired
	private RestauranteRepository restauranteRepository;
	
	public void persitir(Restaurante restaurante) throws Exception {
		try {
			restauranteRepository.save(restaurante);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new Exception("Houve um erro ao persitir o restaurante.");
		}
	}

	public List<Restaurante> findAll() throws Exception {
		try {
			return (List<Restaurante>) restauranteRepository.findAll();
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new Exception("Houve um erro ao consultar os restaurantes."); 
		}
		
	}
}
