/**
 * 
 */
package com.br.itsingular.services;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.itsingular.entity.Empresa;
import com.br.itsingular.entity.Requisicao;
import com.br.itsingular.utils.Utils;

/**
 * @author guilherme
 *
 */
@Service
public class EmpresaServices {

	@Autowired
	private EmpresaServices services;
	
	public Requisicao save(Empresa empresa) {
		try {
			if(!Utils.isEmptyOrNull((Entity) empresa)) {
				return  services.save(empresa);
			}		
		} catch (RuntimeException e) {
			throw e;
		}
		return null;
	}
}
