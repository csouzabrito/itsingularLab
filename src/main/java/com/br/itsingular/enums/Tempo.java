package com.br.itsingular.enums;

public enum Tempo {

	UM(    1, "1-ANO"),
	DOIS(  2, "2-ANOS" ),
	TRES(  3, "3-ANOS"),
	QUATRO(4, "4-ANOS" ),
	CINCO( 5, "5-ANOS"),
	SEIS(  6, "6-ANOS" ),
	SETE(  7, "7-ANOS"),
	OITO(  8, "8-ANOS" ),
	NOVE(  9, "9-ANOS"),
	DEZ(  10, "10-ANOS" );
	
	private Integer tempo;
	private String descricaoTempo;
	
	private Tempo(Integer tempo, String descricaoTempo) {
		this.tempo = tempo;
		this.descricaoTempo = descricaoTempo;
	}
	
	public Integer getTempo() {
		return tempo;
	}
	public void setTempo(Integer tempo) {
		this.tempo = tempo;
	}
	public String getDescricaoTempo() {
		return descricaoTempo;
	}
	public void setDescricaoTempo(String descricaoTempo) {
		this.descricaoTempo = descricaoTempo;
	}

}
