/**
 * 
 */
package com.br.itsingular.enums;

/**
 * @author dcarneiro
 *
 */
public enum TipoRequisito {

	OBRIGATÓRIO(1, "OBRIGATÓRIO"),
	DESEJÁVEL(2 , "DESEJÁVEL");
	
	private Integer tipoRequisito;
	private String descricaoTipoRequisito;

	private TipoRequisito(Integer tipoRequisito , String descricaoTipoRequisito){
		this.tipoRequisito = tipoRequisito;
		this.descricaoTipoRequisito = descricaoTipoRequisito;
	}

	public Integer getTipoRequisito() {
		return tipoRequisito;
	}

	public void setTipoRequisito(Integer tipoRequisito) {
		this.tipoRequisito = tipoRequisito;
	}

	public String getDescricaoTipoRequisito() {
		return descricaoTipoRequisito;
	}

	public void setDescricaoTipoRequisito(String descricaoTipoRequisito) {
		this.descricaoTipoRequisito = descricaoTipoRequisito;
	}
	
}
