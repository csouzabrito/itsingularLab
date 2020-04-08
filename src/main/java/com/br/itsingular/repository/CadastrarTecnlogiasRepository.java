/**
 * 
 */
package com.br.itsingular.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.br.itsingular.entity.Tecnologias;

/**
 * @author dcarneiro
 *
 */
@Repository
public interface CadastrarTecnlogiasRepository extends MongoRepository<Tecnologias, String> {

}
