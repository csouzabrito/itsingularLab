package com.br.itsingular.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.br.itsingular.model.Pessoa;
import com.br.itsingular.repository.PessoaFilter;
import com.br.itsingular.repository.PessoaRepository;


@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public void salvar(final Pessoa pessoa){
		try{
			this.pessoaRepository.save(pessoa);
		}catch(DataIntegrityViolationException e){
			throw new IllegalArgumentException("Erro ao salvar a pessoa");
		}
	}
	
	public List<Pessoa> listarPessoas(){
		return pessoaRepository.findAll();
	}

	public List<Pessoa> filtrarNomeComercial(final PessoaFilter filtro){
		String nome = filtro.getNome() == null ? "%" : filtro.getNome();
		return pessoaRepository.findByNomeContaining(nome);
	}
	
}
