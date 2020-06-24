/**
 * 
 */
package com.br.itsingular.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.itsingular.entity.Funcionarios;
import com.br.itsingular.repository.FinanceiroRepository;

/**
 * @author dcarneiro
 *
 */
@Service
public class FinanceiroService {

	@Autowired
	private FinanceiroRepository repository;
	
	public List<Funcionarios> findFuncionarios(){
		return Optional.ofNullable(repository.findAll()).get();
	}
	
	public Optional<Funcionarios> findFuncionariosById(final String id) {
		return Optional.ofNullable(repository.findById(id)).get();
	}
}
