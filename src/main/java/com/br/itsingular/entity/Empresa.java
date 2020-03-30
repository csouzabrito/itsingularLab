
package com.br.itsingular.entity;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CNPJ;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "EMPRESA")
@EqualsAndHashCode(of = "cnpj")
public class Empresa implements Serializable {

	private static final long serialVersionUID = 1764081334527695609L;
<<<<<<< HEAD

	
=======

>>>>>>> 1463dd1ba08b0d645b993be0df2cb7c73f5f1acf
	@Id
	private String id;


	@NotBlank(message = "Campo obrigatório")
	private String razaoSocial;

	@CNPJ
	@NotBlank(message = "Campo obrigatório")
	private String cnpj;

	@NotBlank(message = "Campo obrigatório")
	private String fantasia;

	@NotBlank(message = "Campo obrigatório")
	private String ramoAtividade;

	@NotBlank(message = "Campo obrigatório")
	private String endereco;

	@NotBlank(message = "Campo obrigatório")
	private String pessoaContato;

	@NotBlank(message = "Campo obrigatório")
	private String cargo;

	private String telCorporativo;

	private String telCelular;

	@NotBlank(message = "Campo obrigatório")
	@Email
	private String emailContato;

	@NotBlank(message = "Campo obrigatório")
	private String emailFinanceiro;



}
	
