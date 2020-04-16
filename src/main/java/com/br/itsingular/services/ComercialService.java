package com.br.itsingular.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.br.itsingular.entity.Comercial;
import com.br.itsingular.repository.ComercialRepository;


@Service
public class ComercialService {
	
	@Autowired
	@Qualifier("comercialRepository")
	private ComercialRepository comercialRepository;
	
	public void salvar(final Comercial comercial){
		try{
			this.comercialRepository.insert(comercial);
		}catch(DataIntegrityViolationException e){
			throw new IllegalArgumentException("Erro ao salvar o comercial");
		}
	}
}