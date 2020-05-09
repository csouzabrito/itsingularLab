package com.br.itsingular.model;

import com.br.itsingular.enums.IdiomaEnum;
import com.br.itsingular.enums.NivelIdioma;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Idioma {
	
	private IdiomaEnum idioma;
	
	private NivelIdioma nivel;
	
}
