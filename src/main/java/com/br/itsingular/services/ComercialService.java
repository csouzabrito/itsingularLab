package com.br.itsingular.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.br.itsingular.entity.Comercial;
import com.br.itsingular.repository.ComercialRepository;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class ComercialService {
	
	@Autowired
	@Qualifier("comercialRepository")
	private ComercialRepository comercialRepository;
	
	@Transactional
	public void create(final Comercial comercial){
		log.info("Registrando comercial{}");
		try{
			this.comercialRepository.save(comercial);
		log.info("Comercial registrado{}");
		}catch(DataIntegrityViolationException e){
			throw new IllegalArgumentException("Erro ao registrar comercial");
		}
	}
}