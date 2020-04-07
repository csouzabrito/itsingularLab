package com.br.itsingular.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.itsingular.entity.Requisicao;
import com.br.itsingular.entity.Sla;
import com.br.itsingular.repository.SlaRepository;

@Service
public class SlaService {
	
	@Autowired
	private SlaRepository repository;

	public void criarSla(final Requisicao requisicao) {
		
		final Sla sla = Sla.builder()
				.solicitante(requisicao.getNomeSolicitante())
				.dataSolicitacao(requisicao.getDataSolicitacao())
				.tipoRequisicao(requisicao.getTipoRequisicao()).build();
		
		this.repository.save(sla);
	}
	
}
