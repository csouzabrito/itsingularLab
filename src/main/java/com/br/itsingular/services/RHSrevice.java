package com.br.itsingular.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.br.itsingular.custom.repository.MongoCustomRepository;
import com.br.itsingular.entity.Requisicao;
import com.br.itsingular.enums.StatusRequisicao;
import com.br.itsingular.repository.RequisicaoRepository;

@Service
public class RHSrevice {
	
	
	@Autowired
	private RequisicaoRepository repository;
	
	@Autowired
	private MongoCustomRepository customRepository;
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public List<Requisicao> findRequisicao(){
		return this.repository.findAll();
	}
	
	public Optional<Requisicao> findRequisicaoById(final String id) {
		return this.repository.findById(id);
	}
	
	public List<Requisicao> filtrarVagas(final String filtro) {
		return this.customRepository.findRequisicaoByFilter(filtro);

	}
	
	public void updateResposavelRequisicao(Requisicao vaga, String usernameResponsavel) {
		try {
			Query query = new Query();
			query.addCriteria(Criteria.where("_id").is(vaga.getId()));
			Update update = new Update();
			update.set("status", StatusRequisicao.EM_ANDAMENTO);
			update.set("responsavelRh", usernameResponsavel);	
			mongoTemplate.findAndModify(query, update, Requisicao.class);
		} catch (RuntimeException e) {
			throw e;
		}
	}
	
	
	public void updateConcluirTarefa(Requisicao vaga, String usernameResponsavel) {
		try {
			Query query = new Query();
			query.addCriteria(Criteria.where("_id").is(vaga.getId()));
			Update update = new Update();
			update.set("status", StatusRequisicao.REQUISICAO_CONCLUIDA);
			update.set("responsavelRh", usernameResponsavel);	
			mongoTemplate.findAndModify(query, update, Requisicao.class);
		} catch (RuntimeException e) {
			throw e;
		}
	}
}
