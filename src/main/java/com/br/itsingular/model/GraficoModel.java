package com.br.itsingular.model;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GraficoModel {
	
	@NotBlank(message = "Campo obrigatório")
	private String percentualConhecimento;
	
	@NotBlank(message = "Campo obrigatório")
	private String tecnoloagia;

}
