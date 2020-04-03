package com.br.itsingular.entity;

import java.time.LocalDate;

import org.springframework.data.mongodb.core.mapping.Document;

import com.br.itsingular.enums.TipoRequisicao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "SLA_VAGAS")
public class Sla {
	
	private String id;
	
	private String solicitante;
	
	private LocalDate dataSolicitacao;
	
	private TipoRequisicao tipoRequisicao;
}
