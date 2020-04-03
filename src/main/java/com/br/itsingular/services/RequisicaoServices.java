package com.br.itsingular.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.br.itsingular.entity.Requisicao;
import com.br.itsingular.repository.RequisicaoRepository;

/**
 * @author dcarneiro
 *
 */
@Service
public class RequisicaoServices {
	
	public int PAGE = 0;
	public int SIZE = 10;

	@Autowired
	private RequisicaoRepository repository;
	
	public Requisicao salvarRequisicao(Requisicao requisicao ) {
		try {
			return this.repository.insert(requisicao);
		} catch (RuntimeException e) {
			throw e;
		}
	}
	
	public List<Requisicao> listar() {
		
		Page<Requisicao> requisicoes = this.repository.findAll(PageRequest.of(PAGE, SIZE));
		
		return requisicoes.getContent();
	}
	
	public List<Requisicao> getInfoByEmail(final String email) {
		return repository.findByEmail(email);
	}
	
	public List<Requisicao> filtrarRequisicao(final RequisicaoFilter filtro) {
		
		String cliente = filtro.getDescricao() == null ? "%" : filtro.getDescricao();
		List<Requisicao> requisicoes = repository.findByClienteContaining(cliente);
		
		return requisicoes;
	}
}