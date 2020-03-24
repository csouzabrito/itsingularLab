/**
 * 
 */
package com.br.itsingular.enums;

/**
 * @author dcarneiro
 *
 */
public enum TipoContratacao {

	CLT("CLT"), 
	PJ("PJ"), 
	FLEX("FLEX"), 
	IBRATI("IBRATI"),
	COOPERATIVA("Cooperativa"); 
	
	private String tipoContratacao;
		
	TipoContratacao(String tipoContratacao) {
		this.tipoContratacao = tipoContratacao;
	}
	public String getTipoContratacao() {
		return tipoContratacao;
	}
	public void setTipoContratacao(String tipoContratacao) {
		this.tipoContratacao = tipoContratacao;
	}
}
