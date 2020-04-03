package com.br.itsingular.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.br.itsingular.entity.Sla;

@Repository
public interface SlaRepository extends MongoRepository<Sla, String>{

}
