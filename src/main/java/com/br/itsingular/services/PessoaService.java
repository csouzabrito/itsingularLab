package com.br.itsingular.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.br.itsingular.entity.Pessoa;
import com.br.itsingular.repository.PessoaRepository;


@Service
public class PessoaService {
	
	@Autowired
	@Qualifier("pessoaRepository")
	private PessoaRepository pessoaRepository;
	
	public void salvar(final Pessoa pessoa){
		try{
			this.pessoaRepository.insert(pessoa);
		}catch(DataIntegrityViolationException e){
			throw new IllegalArgumentException("Erro ao salvar a pessoa");
		}
	}
}