package com.br.itsingular.services;

import static com.br.itsingular.utils.Utils.toPageable;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
		return this.repository.findAll(PageRequest.of(page, size));
	}
	
	public Page<Requisicao> filtrarVagas(final String filtro, final int page, final int size) {
		
		final List<Requisicao> requisicoes = this.customRepository.findRequisicaoByFilter(filtro, page, size);
		
		return toPageable(requisicoes);
	}
}
