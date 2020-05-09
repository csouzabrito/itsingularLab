package com.br.itsingular.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.br.itsingular.entity.Candidado;

@Repository
public interface CandidatoRepository extends MongoRepository<Candidado, String>{

}
