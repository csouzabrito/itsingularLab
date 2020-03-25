/**
 * 
 */
package com.br.itsingular.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.br.itsingular.model.Requisicao;

/**
 * @author dcarneiro
 *
 */
@Repository
public interface IRequisicaoRepository extends MongoRepository<Requisicao, String> {

	List<Requisicao> findByEmail(String filtro);
}
