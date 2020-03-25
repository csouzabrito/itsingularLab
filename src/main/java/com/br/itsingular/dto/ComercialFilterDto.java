package com.br.itsingular.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;

import lombok.Setter;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ComercialFilterDto implements Serializable{
	
	private static final long serialVersionUID = -4854555577050803172L;

	private String nome;
	
	private String email;
}
