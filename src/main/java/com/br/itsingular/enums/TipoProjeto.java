/**
 * 
 */
package com.br.itsingular.enums;

/**
 * @author dcarneiro
 *
 */
public enum TipoProjeto {

	HORA(1,"HORA"),
	MES(2,"MES"),
	PROJETO(3,"PROJETO");
		
	private Integer tipoProjeto;
	private String descricaoTipoProjeto;
	
	private TipoProjeto(Integer tipoProjeto, String descricaoTipoProjeto){
		this.tipoProjeto = tipoProjeto;
	}

	public Integer getTipoProjeto() {
		return tipoProjeto;
	}

	public void setTipoProjeto(Integer tipoProjeto) {
		this.tipoProjeto = tipoProjeto;
	}

	public String getDescricaoTipoProjeto() {
		return descricaoTipoProjeto;
	}

	public void setDescricaoTipoProjeto(String descricaoTipoProjeto) {
		this.descricaoTipoProjeto = descricaoTipoProjeto;
	}

}
