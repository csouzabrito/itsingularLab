package com.br.itsingular.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
	public Page<Curriculos> findCurriculos(Pageable pageable){
		return cadastrarCurriculo.findAll(pageable);
	}
	public Optional<Curriculos> findCurriculoById(String id){
		return Optional.ofNullable(cadastrarCurriculo.findById(id).get());
	}
	/**
	 * Este processo ocorrerá porque o RH poderá 
	 *      alterar o CPF (CPF é chave da Entity)
	 * @param curriculos
	 */
	public void removeAndInsertCurriculos(Curriculos curriculos) {
		try {
			cadastrarCurriculo.deleteById(curriculos.getCpf());
			cadastrarCurriculo.insert(curriculos);
		} catch (RuntimeException e) {
			throw e;
		}
	}
	
}
