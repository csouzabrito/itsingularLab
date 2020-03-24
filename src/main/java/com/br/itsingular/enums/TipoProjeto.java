/**
 * 
 */
package com.br.itsingular.enums;

/**
 * @author dcarneiro
 *
 */
public enum TipoProjeto {

	HORA("HORA"),
	MES("MES"),
	PROJETO("PROJETO");
		
	private String tipoProjeto;

	TipoProjeto(String tipoProjeto){
		this.tipoProjeto = tipoProjeto;
	}
	public String getTipoProjeto() {
		return tipoProjeto;
	}
	public void setTipoProjeto(String tipoProjeto) {
		this.tipoProjeto = tipoProjeto;
	}
}
