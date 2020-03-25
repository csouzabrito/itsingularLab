/**
 * 
 */
package com.br.itsingular.model;

import javax.persistence.Column;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author dcarneiro
 *
 */
@NoArgsConstructor
@Getter
@Setter
public class RequisitosModel{

	@Column(name = "tipoRequisito")
	private Integer tipoRequisito;
	
	@Column(name = "requisitoConhecimento")
	private Integer requisitoConhecimento;
	
	@Column(name = "tempoExperiencia")
	private Integer tempoExperiencia;


}
