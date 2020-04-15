package com.br.itsingular.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.itsingular.entity.Curriculos;
import com.br.itsingular.repository.CadastrarCurriculosRepository;

@Service
public class CadastrarCurriculosServices {

	@Autowired
	private CadastrarCurriculosRepository cadastrarCurriculo;
	
	public void save( final Curriculos curriculos) {
		try {
			cadastrarCurriculo.insert(curriculos);
		} catch (Exception e) {
			throw e;
		}
	}
	public List<Curriculos> findCurriculos(){
		return cadastrarCurriculo.findAll();
	}
	public Optional<Curriculos> findCurriculoById(String id){
		return Optional.ofNullable(cadastrarCurriculo.findById(id).get());
	}
	
}
