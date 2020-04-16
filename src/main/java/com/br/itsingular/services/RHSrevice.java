package com.br.itsingular.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.br.itsingular.custom.repository.MongoCustomRepository;
import com.br.itsingular.entity.Requisicao;
import com.br.itsingular.repository.RequisicaoRepository;

@Service
public class RHSrevice {
	
	
	@Autowired
	private RequisicaoRepository repository;
	
	@Autowired
	private MongoCustomRepository customRepository;
	
	public Page<Requisicao> findRequisicao(final int page, final int size){
		
		final Page<Requisicao> requisicoes = this.repository.findAll(PageRequest.of(page, size));
		
		return requisicoes;
	}
	
	public Page<Requisicao> filtrarVagas(final String filtro, final int page, final int size) {
		
		List<Requisicao> requisicoes = this.customRepository.findRequisicaoByFilter(filtro);
		
		final Page<Requisicao> requisicaoPageble = new PageImpl<>(requisicoes);
		
		return requisicaoPageble;
	}
}
