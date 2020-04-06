package com.br.itsingular.services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.br.itsingular.entity.Requisicao;
import com.br.itsingular.enums.StatusRequisicao;
import com.br.itsingular.enums.TipoRequisicao;
import com.br.itsingular.repository.RequisicaoRepository;

/**
 * @author dcarneiro
 *
 */
@Service
public class RequisicaoServices {
	
	@Autowired
	private SlaService slaService;
	
	@Autowired
	private RequisicaoRepository repository;
	
	public Requisicao salvarRequisicao(Requisicao requisicao ) {
		
		try {
			
			requisicao.setStatus(StatusRequisicao.PENDENTE);
			
			Integer sla = requisicao.getTipoRequisicao() == TipoRequisicao.CONTRATACAO_PROJETOS ? 3 : 5;
			requisicao.setSla(sla);
			
			Requisicao newRequisicao = this.repository.insert(requisicao);
			
			this.slaService.criarSla(newRequisicao);
			
			return  newRequisicao;
		} catch (RuntimeException e) {
			throw e;
		}
	}
	
	public List<Requisicao> getInfoByEmail(final String email) {
		
		List<Requisicao> requisicoesComSLA = new ArrayList<>();
		
		List<Requisicao> requisicoes = repository.findByEmail(email);
		
		requisicoes.forEach(r -> {
			requisicoesComSLA.add(formatDate(r));
		});
		
		return requisicoesComSLA;
	}
	
	public List<Requisicao> filtrarRequisicao(final RequisicaoFilter filtro) {
		
		String cliente = filtro.getDescricao() == null ? "%" : filtro.getDescricao();
		List<Requisicao> requisicoes = repository.findByClienteContaining(cliente);
		
		return requisicoes;
	}
	
	private Requisicao formatDate(Requisicao requisicao){
		
		LocalDate dataSolicitacao = LocalDate.parse(requisicao.getDataSolicitacao());
		
		String dataFormatada = dataSolicitacao.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		
		requisicao.setDataSolicitacao(dataFormatada);

		return requisicao;
	}

}