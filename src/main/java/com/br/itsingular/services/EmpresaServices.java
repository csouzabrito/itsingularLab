/**
 * 
 */
package com.br.itsingular.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.br.itsingular.dto.EmpresaDTO;
import com.br.itsingular.entity.Empresa;
import com.br.itsingular.repository.EmpresaRepository;

/**
 * @author guilherme
 *
 */
@Service
public class EmpresaServices {

	@Autowired
	private EmpresaRepository repository;
	
	public Empresa save(Empresa empresa) {
		return  repository.save(empresa);
	}
	
	public Page<Empresa> list() {
		Page<Empresa> lista = repository.findAll(PageRequest.of(0, 15));
		if (!lista.getContent().isEmpty()) {
			return lista;
		}
		return lista;
	}

	public Page<Empresa> getInfoByFilter(final String filtro) {
		
		Page<Empresa> empresas = null; // = repository.;  PAREI AQUI- nao acho o metodo que busca com parametro cnpj
		
		return empresas;
	}
	
	public EmpresaDTO findEmpresa(EmpresaDTO request) {
		
//		List<Empresa> return = this.repository.findAll(request);
		
		return new EmpresaDTO();
		
	}

}
