/**
 * 
 */
package com.br.itsingular.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.br.itsingular.entity.Tecnologias;
import com.br.itsingular.repository.CadastrarTecnlogiasRepository;

/**
 * @author dcarneiro
 *
 */
@Service
public class CadastrarTecnologiasServices {

	@Autowired
	private CadastrarTecnlogiasRepository cadTecnologias;
	
	@Autowired
	private MongoTemplate mongoTemplate;

	public void insertTecnologias(Tecnologias cursos) {
		try {
			cadTecnologias.insert(cursos);
		} catch (RuntimeException e) {
			throw e;
		}
	}
	public List<Tecnologias> findTecnologias() {
		return Optional.ofNullable(cadTecnologias.findAll()).get();
	}
	public Optional<Tecnologias> findTecnologiasById(String id) {
		return Optional.ofNullable(cadTecnologias.findById(id)).get();
	}
	public void deleteTecnologias(String id) {
		try {
			cadTecnologias.deleteById(id);
		} catch (RuntimeException e) {
			throw e;
		}
	}
	public void updateTecnologias(String id, Tecnologias cursos) {
		try {
			Query query = new Query();
			query.addCriteria(Criteria.where("_id").is(cursos.getId()));
			Update update = new Update();
			update.set("versao", cursos.getVersao());
			update.set("descricaoResumida", cursos.getDescricaoResumida());	
			mongoTemplate.findAndModify(query, update, Tecnologias.class);
		} catch (RuntimeException e) {
			throw e;
		}
	}

}
