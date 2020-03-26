/**
 * 
 */
package com.br.itsingular.enums;

/**
 * @author dcarneiro
 *
 */
public enum TipoQualificacaoTestes {

	ADT(1, "ADT"),
	FTP(2, "FTP"),
	RAC_LÓGICO(3, "RAC_LÓGICO"),
	REDAÇÃO(4, "REDAÇÃO"),
	TÉCNICO(5, "TÉCNICO"),
	OUTROS(6, "OUTROS");
	
	private Integer tipoQualificacaoTestes;
	private String descricaotipoQualificacaoTestes;

	private TipoQualificacaoTestes(Integer tipoqualificacaoTestes, String descricaotipoQualificacaoTestes){
		this.tipoQualificacaoTestes = tipoqualificacaoTestes;
		this.descricaotipoQualificacaoTestes = descricaotipoQualificacaoTestes;
	
	}
	public Integer getTipoQualificacaoTestes() {
		return tipoQualificacaoTestes;
	}
	public void setTipoQualificacaoTestes(Integer tipoQualificacaoTestes) {
		this.tipoQualificacaoTestes = tipoQualificacaoTestes;
	}
	public String getDescricaotipoQualificacaoTestes() {
		return descricaotipoQualificacaoTestes;
	}
	public void setDescricaotipoQualificacaoTestes(String descricaotipoQualificacaoTestes) {
		this.descricaotipoQualificacaoTestes = descricaotipoQualificacaoTestes;
	}

}
