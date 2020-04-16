package com.br.itsingular.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.br.itsingular.entity.Comercial;

@Repository
public interface ComercialRepository extends MongoRepository<Comercial, Long> {
}
