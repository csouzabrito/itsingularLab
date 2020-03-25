/**
 * 
 */
package com.br.itsingular.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author dcarneiro
 *
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Document(collection = "REQUISITOS_OPORTUNIDADE")
public class Requisitos implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private Long id;
	
	@ManyToOne
	@JoinColumn
	private Requisicao requisicao;
	
	@Column(name = "tipoRequisito")
	private String tipoRequisito;
	
	@Column(name = "requisitoConhecimento")
	private String requisitoConhecimento;
	
	@Column(name = "tempoExperiencia")
	private String tempoExperiencia;

}
