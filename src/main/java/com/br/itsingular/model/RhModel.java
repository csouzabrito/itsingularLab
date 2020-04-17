package com.br.itsingular.model;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import com.br.itsingular.enums.StatusRequisicao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RhModel {
	
	@NotBlank(message = "Campo obrigatório")
	private String nomeSolicitante;

	@NotBlank(message = "Campo obrigatório")
	private LocalDate dataSolicitacao;

	@NotBlank(message = "Campo obrigatório")
	private String cliente;

	@NotBlank(message = "Campo obrigatório")
	private String ramoAtividade;

	@NotBlank(message = "Campo obrigatório")
	private String endereco;

	@NotBlank(message = "Campo obrigatório")
	private String regiao;

	@NotBlank(message = "Campo obrigatório")
	private String pessoaContato;
	
	private StatusRequisicao status;
	
}
