package com.br.itsingular.services;

import static com.br.itsingular.utils.Utils.toPageable;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

	public Page<Requisicao> getInfoBySolicitante(final String email, final int page, final int size ) {

		final Pageable pageable = PageRequest.of(page, size);
		
		Page<Requisicao> requisicoes = this.repository.findByNomeSolicitante(email, pageable);
		
		return requisicoes;
	}
	
	public Page<Requisicao> filtrarRequisicao(final String filtro, final int page, final int size) {
		
		List<Requisicao> requisicoes = this.customRepository.findRequisicaoByFilter(filtro, page, size);
		
		return toPageable(requisicoes);
	}
	
	public Page<Requisicao> listarRequisicoes(final int page, final int size){
		
		final Page<Requisicao> requisicoes = this.repository.findAll(PageRequest.of(page, size));
		
		return requisicoes;
	}
}