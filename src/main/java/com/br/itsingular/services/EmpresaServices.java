/**
 * 
 */
package com.br.itsingular.services;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.itsingular.entity.Empresa;
import com.br.itsingular.repository.EmpresaRepository;
import com.br.itsingular.utils.Utils;

/**
 * @author guilherme
 *
 */
@Service
public class EmpresaServices {

	@Autowired
	private EmpresaRepository empresaRepository;
	
	public Empresa save(Empresa empresa) {
		try {
			if(!Utils.isEmptyOrNull((Entity) empresa)) {
				return empresaRepository.save(empresa);
			}		
		} catch (RuntimeException e) {
			throw e;
		}
		return null;
	}
}
