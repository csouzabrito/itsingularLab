package com.br.itsingular.custom.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import com.br.itsingular.entity.Requisicao;

@Component
public class MongoCustomRepository {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public List<Requisicao> findVagasByFilter(final String filtro,final int page, final int size) {
		
		List<Requisicao> vagas = mongoTemplate.find(Query.query(new Criteria()
				.orOperator(Criteria.where("dataSolicitacao").is(filtro), 
							Criteria.where("cliente").regex(filtro,"i"), 
							Criteria.where("vaga").regex(filtro, "i"),
							Criteria.where("ramoAtividade").regex(filtro, "i"),
							Criteria.where("sla").gte(filtro),
							Criteria.where("status").regex(filtro))),Requisicao.class);
				
		return vagas;
	}
	
	public List<Requisicao>  findRequisicaoByFilter(final String filtro) {
		
		Query query = new Query();
		
		query.addCriteria(new Criteria()
				.orOperator(Criteria.where("dataSolicitacao").is(filtro), 
						Criteria.where("cliente").regex(filtro,"i"), 
						Criteria.where("cargo").regex(filtro, "i"),
						Criteria.where("ramoAtividade").regex(filtro, "i"),
						Criteria.where("status").regex(filtro)));
		
		return mongoTemplate.find(query, Requisicao.class);
	}	
}