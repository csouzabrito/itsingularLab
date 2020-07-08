package com.br.itsingular.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.br.itsingular.entity.Curriculos;
import com.br.itsingular.entity.Requisicao;
import com.br.itsingular.repository.CadastrarCurriculosRepository;
import com.br.itsingular.utils.Utils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CadastrarCurriculosServices {

	@Autowired
	private CadastrarCurriculosRepository repository;

	public void insert( final Curriculos curriculos) {
		try {
			repository.insert(curriculos);
		} catch (Exception e) {
			throw e;
		}
	}
	public List<Curriculos> findCurriculos(){
		return repository.findAll();
	}
	public Optional<Curriculos> findCurriculoById(String id){
		return Optional.ofNullable(repository.findById(id).get());
	}
	public void removeAndInsertCurriculos(Curriculos curriculos) {
		try {
			repository.delete(curriculos);
			repository.insert(curriculos);
		} catch (RuntimeException e) {
			throw e;
		}
	}
	@Cacheable("cvs")
	public List<Curriculos> findByIds(final Requisicao vaga){
		List<String> ids = new ArrayList<String>();
		if(!Utils.isEmptyOrNull(vaga.getRequisitoObrigatorio())){
			for (String iterable_element : vaga.getRequisitoObrigatorio()) {
				ids.add(iterable_element);
			}
		}	
		if(!Utils.isEmptyOrNull(vaga.getRequisitoConhecimento())){
			for (String iterable_element : vaga.getRequisitoConhecimento()) {
				ids.add(iterable_element);
			}
		}
		log.info("Buscando um currículos por ID's {}", ids);
		List<Curriculos> curriculos = this.repository.findByTecnologiasAssociadasIn(ids);
		
		return curriculos;
	}
}
