package com.br.itsingular.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.itsingular.entity.Requisicao;
import com.br.itsingular.repository.RequisicaoRepository;

/**
 * @author dcarneiro
 *
 */
@Service
public class RequisicaoServices {

	@Autowired
	private RequisicaoRepository services;
	
	public Requisicao salvarRequisicao(Requisicao requisicao ) {
		try {
			return this.services.insert(requisicao);
		} catch (RuntimeException e) {
			throw e;
		}
	}
}
