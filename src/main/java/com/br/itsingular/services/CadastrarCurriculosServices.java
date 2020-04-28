package com.br.itsingular.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.br.itsingular.entity.Curriculos;
import com.br.itsingular.entity.Requisicao;
import com.br.itsingular.repository.CadastrarCurriculosRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CadastrarCurriculosServices {

	@Autowired
	private CadastrarCurriculosRepository repository;
	
	public void save( final Curriculos curriculos) {
		try {
			repository.insert(curriculos);
		} catch (Exception e) {
			throw e;
		}
	}
	public List<Curriculos> findCurriculos(){
		return repository.findAll();
	}
		
	public Page<Curriculos> findCurriculos(Pageable pageable){
		return repository.findAll(pageable);
	}
	public Optional<Curriculos> findCurriculoById(String id){
		return Optional.ofNullable(repository.findById(id).get());
	}
	/**
	 * Este processo ocorrerá porque o RH poderá 
	 *      alterar o CPF (CPF é chave da Entity)
	 * @param curriculos
	 */
	public void removeAndInsertCurriculos(Curriculos curriculos) {
		try {
			repository.deleteById(curriculos.getCpf());
			repository.insert(curriculos);
		} catch (RuntimeException e) {
			throw e;
		}
	}
	
	
	@Cacheable("cvs")
	public List<Curriculos> findByIds(final Requisicao vaga){
		List<String> ids = Arrays.asList(vaga.getRequisitoObrigatorio());
		log.info("Buscando um currículos por ID's {}", ids);
		List<Curriculos> curriculos = this.repository.findByTecnologiasAssociadasIn(ids);
		
		return curriculos;
	}
}
