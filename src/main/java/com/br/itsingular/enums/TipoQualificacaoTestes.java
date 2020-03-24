/**
 * 
 */
package com.br.itsingular.enums;

/**
 * @author dcarneiro
 *
 */
public enum TipoQualificacaoTestes {

	
	ADT(1,"ADT"),
	FTP(2,"FTP"),
	RAC_LÓGICO(3,"RAC LÓGICO"),
	REDAÇÃO(4,"REDACAO"),
	TÉCNICO(5,"TECNICO"),
	OUTROS(6,"OUTROS");
	
	private Integer tipoQualificacaoTestes;
	private String descricaoQualificacaoTestes;
	
	TipoQualificacaoTestes(Integer tipoqualificacaoTestes, String descricaoQualificacaoTestes){
		this.tipoQualificacaoTestes = tipoqualificacaoTestes;
		this.descricaoQualificacaoTestes = descricaoQualificacaoTestes;
	}
	public Integer getTipoQualificacaoTestes() {
		return tipoQualificacaoTestes;
	}
	public void setTipoQualificacaoTestes(Integer tipoQualificacaoTestes) {
		this.tipoQualificacaoTestes = tipoQualificacaoTestes;
	}
	public String getDescricaoQualificacaoTestes() {
		return descricaoQualificacaoTestes;
	}
	public void setDescricaoQualificacaoTestes(String descricaoQualificacaoTestes) {
		this.descricaoQualificacaoTestes = descricaoQualificacaoTestes;
	}


}
