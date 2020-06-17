package com.br.itsingular.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.br.itsingular.entity.Funcionarios;
import com.mongodb.client.MongoClient;

@Repository
public interface FuncionariosRepository extends MongoRepository<Funcionarios, String>, MongoClient {

}
