package com.br.itsingular.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.br.itsingular.custom.repository.MongoCustomRepository;
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

	@Value("${collection}")
	private String collection;
	
	@Autowired
	private SlaService slaService;

	@Autowired
	private RequisicaoRepository repository;
	
	@Autowired
	private MongoCustomRepository customRepository;
	
	public Requisicao salvarRequisicao(Requisicao requisicao) {

		try {
			requisicao.setStatus(StatusRequisicao.PENDENTE.getDescricao());
			Integer sla = requisicao.getTipoRequisicao() == TipoRequisicao.CONTRATACAO_PROJETOS ? 3 : 5;
			requisicao.setSla(sla);
			Requisicao newRequisicao = this.repository.insert(requisicao);
			this.slaService.criarSla(newRequisicao);
			return newRequisicao;
		} catch (RuntimeException e) {
			throw e;
		}
	}

	public List<Requisicao> getInfoByEmail(final String email) {

		List<Requisicao> requisicoes = repository.findByEmail(email);

		return requisicoes;
	}

	public List<Requisicao> filtrarRequisicao(final String filtro) {
		
		List<Requisicao> requisicoes = customRepository.findRequisicaoByFilter(filtro);
		
		return requisicoes;
	}
	
}