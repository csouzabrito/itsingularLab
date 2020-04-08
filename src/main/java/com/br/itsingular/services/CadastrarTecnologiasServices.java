/**
 * 
 */
package com.br.itsingular.services;

import java.util.ArrayList;
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
import com.mongodb.MongoException;

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

	/**
	 * 
	 * @param cursos
	 */
	public void insertCurso(Tecnologias cursos) {
		try {
			cadTecnologias.insert(cursos);
		} catch (RuntimeException e) {
			throw e;
		}
	}
	/**
	 * 
	 * @return
	 */
	public List<Tecnologias> findCursos() {
		List<Tecnologias> listCursos = new ArrayList<Tecnologias>();
		try {
			cadTecnologias.findAll().forEach(l -> { listCursos.add(l); });
		} catch (MongoException e) {
			throw e;
		}
		return listCursos;
	}
	/**
	 * 
	 * @return
	 */
	public Optional<Tecnologias> findCursosById(String id) {
		try {
			return cadTecnologias.findById(id);
		} catch (RuntimeException e) {
			throw e;
		}
	}
	/**
	 * 
	 * @return
	 */
	public void deleteCursos(String id) {
		try {
			cadTecnologias.deleteById(id);
		} catch (RuntimeException e) {
			throw e;
		}
	}
	/**
	 * 
	 * @return
	 */
	public void UpdateCursos(String id, Tecnologias cursos) {
		try {
			Query query = new Query();
			query.addCriteria(Criteria.where("_id").is(cursos.getId()));
			Update update = new Update();
			update.set("versao", cursos.getVersao());
			update.set("descricaoResumida", cursos.getDescricaoResumida());
			update.set("dataInclOrManut", cursos.getDataInclOrManut());
			update.set("usuario", cursos.getUsuario());		
			mongoTemplate.findAndModify(query, update, Tecnologias.class);
		} catch (RuntimeException e) {
			throw e;
		}
	}
}
