package br.com.restaurante.microservice.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.restaurante.microservice.model.TipoComida;
import br.com.restaurante.microservice.respository.TipoComidaRepository;

@Service
public class TipoComidaService {

	private static final Logger logger = LogManager.getLogger(TipoComidaService.class);
	
	@Autowired
	private TipoComidaRepository tipoComidaRepository;
	
	public void persitir(TipoComida tipoComida) throws Exception {
		try {
			tipoComidaRepository.save(tipoComida);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new Exception("Houve um erro ao gravar o Tipo de comida.");
		}
	}
	
	public List<TipoComida> findAll() throws Exception {
		try {
			return (List<TipoComida>) tipoComidaRepository.findAll();
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new Exception("Houve um erro ao consultar os Tipos de comida.");
		}
	}


}
