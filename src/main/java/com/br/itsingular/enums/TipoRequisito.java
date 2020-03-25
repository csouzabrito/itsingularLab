/**
 * 
 */
package com.br.itsingular.enums;

/**
 * @author dcarneiro
 *
 */
public enum TipoRequisito {

	OBRIGATÓRIO("1"),
	DESEJÁVEL("2");
	
	private String tipoRequisito;

	private TipoRequisito(String tipoRequisito){
		this.tipoRequisito = tipoRequisito;
	}
	
	public String getTipoRequisito() {
		return tipoRequisito;
	}

	public void setTipoRequisito(String tipoRequisito) {
		this.tipoRequisito = tipoRequisito;
	}
}
