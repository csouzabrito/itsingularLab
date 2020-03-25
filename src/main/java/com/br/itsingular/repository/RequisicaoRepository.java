/**
 * 
 */
package com.br.itsingular.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.br.itsingular.entity.Requisicao;

/**
 * @author dcarneiro
 *
 */
@Repository
public interface RequisicaoRepository extends MongoRepository<Requisicao, String> {}
