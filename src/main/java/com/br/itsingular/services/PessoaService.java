package com.br.itsingular.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.br.itsingular.entity.Pessoa;
import com.br.itsingular.entity.Requisicao;
import com.br.itsingular.repository.PessoaRepository;
import com.br.itsingular.repository.RequisicaoRepository;


@Service
public class PessoaService {
	
	@Autowired
	@Qualifier("pessoaRepository")
	private PessoaRepository pessoaRepository;
	
	@Autowired
	private RequisicaoRepository requisicaoRepository;
	
	public void salvar(final Pessoa pessoa){
		try{
			this.pessoaRepository.insert(pessoa);
		}catch(DataIntegrityViolationException e){
			throw new IllegalArgumentException("Erro ao salvar a pessoa");
		}
	}
	
	public List<Pessoa> listarPessoas(){
		return pessoaRepository.findAll();
	}

	public List<Requisicao> getInfoByFilter(final String filtro) {
		
		String info = filtro == null ? "%" : filtro;
		List<Requisicao> requisicao = requisicaoRepository.findByEmail(info);
		
		return requisicao;
	}
}