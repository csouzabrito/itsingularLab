/**
 * 
 */
package com.br.itsingular.controller.repository;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.itsingular.model.Requisicao;
import com.br.itsingular.services.IRequisicaoServices;
import com.br.itsingular.utils.Utils;

/**
 * @author dcarneiro
 *
 */
@Service
public class RequisicaoServices {

	@Autowired
	private IRequisicaoServices services;
	
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
