/**
 * 
 */
package com.br.itsingular.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.br.itsingular.entity.Requisicao;

/**
 * @author dcarneiro
 *
 */
@Repository
public interface RequisicaoRepository extends MongoRepository<Requisicao, String> {

	List<Requisicao> findByEmail(String filtro);

	List<Requisicao> findByClienteContaining(String filtro);
}
