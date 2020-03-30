/**
 * 
 */
package com.br.itsingular.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.br.itsingular.entity.Cursos;

/**
 * @author dcarneiro
 *
 */
@Repository
public interface CadastrarCursosRepository extends MongoRepository<Cursos, String> {

}
