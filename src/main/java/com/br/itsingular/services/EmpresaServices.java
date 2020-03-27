/**
 * 
 */
package com.br.itsingular.services;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
	private EmpresaRepository repository;
	
	public Empresa save(Empresa empresa) {
		try {
			if(!Utils.isEmptyOrNull((Entity) empresa)) {
				return  repository.save(empresa);
			}		
		} catch (RuntimeException e) {
			throw e;
		}
		return null;
	}
	
	public Page<Empresa> list() {
		Page<Empresa> lista = repository.findAll(PageRequest.of(0, 15));
		if (!lista.getContent().isEmpty()) {
			return lista;
		}
		return lista;
	}
}
