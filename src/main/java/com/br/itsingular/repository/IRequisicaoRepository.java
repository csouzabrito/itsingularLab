/**
 * 
 */
package com.br.itsingular.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.itsingular.model.Requisicao;

/**
 * @author dcarneiro
 *
 */
@Repository
public interface IRequisicaoRepository extends JpaRepository<Requisicao, Long> {}
