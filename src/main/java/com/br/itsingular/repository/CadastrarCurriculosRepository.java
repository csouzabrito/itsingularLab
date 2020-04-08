package com.br.itsingular.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.br.itsingular.entity.Curriculos;

@Repository
public interface CadastrarCurriculosRepository extends MongoRepository<Curriculos, String> {

}
