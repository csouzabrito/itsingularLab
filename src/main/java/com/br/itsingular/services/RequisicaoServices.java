package com.br.itsingular.services;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.itsingular.model.Requisicao;
import com.br.itsingular.repository.IRequisicaoRepository;
import com.br.itsingular.utils.Utils;

/**
 * @author dcarneiro
 *
 */
@Service
public class RequisicaoServices {

	@Autowired
	private IRequisicaoRepository services;
	
	public Requisicao salvarRequisicao(Requisicao requisicao ) {
		try {
			
			return this.services.save(requisicao);
			
		} catch (RuntimeException e) {
			throw e;
		}
	}
	
	@Deprecated
	public Requisicao save(Requisicao requisicao ) {
		try {
			if(!Utils.isEmptyOrNull((Entity) requisicao)) {
				return  services.save(requisicao);
			}		
		} catch (RuntimeException e) {
			throw e;
		}
		return null;
	}
}
