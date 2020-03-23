/**
 * 
 */
package com.br.itsingular.services;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.br.itsingular.model.Requisicao;

/**
 * @author dcarneiro
 *
 */
@Repository
public interface IRequisicaoServices extends MongoRepository<Requisicao, String> {}
