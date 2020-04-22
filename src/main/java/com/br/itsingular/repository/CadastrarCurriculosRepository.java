package com.br.itsingular.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.br.itsingular.entity.Curriculos;

@Repository
public interface CadastrarCurriculosRepository extends MongoRepository<Curriculos, String> {

	List<Curriculos> findByTecnologiasAssociadasIn(List<String> ids);
	
}
