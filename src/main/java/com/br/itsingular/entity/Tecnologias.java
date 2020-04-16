package com.br.itsingular.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import com.br.itsingular.utils.Utils;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "CADASTRAR_TECNOLOGIAS")
public class Tecnologias implements Serializable { 

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	
	@NotBlank(message = "Campo obrigatório")
	private String nomeCurso;
	
	@NotBlank(message = "Campo obrigatório")
	private String versao;
	
	@NotBlank(message = "Campo obrigatório")
	private String descricaoResumida;
	
	@LastModifiedDate
	private LocalDate dataInclOrManut;
	
	@LastModifiedBy
	private String usuario;

	public String getDataManutencaoFormat() {
		return Utils.formatDate(this.getDataInclOrManut());
	}
	
}
