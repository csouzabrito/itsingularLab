
package com.br.itsingular.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.br.CNPJ;
import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmpresaDTO implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 8347476343519784344L;


	@Id
	private String id;

	private String razaoSocial;

	@CNPJ
	private String cnpj;

	private String fantasia;

	private String ramoAtividade;


}
	
