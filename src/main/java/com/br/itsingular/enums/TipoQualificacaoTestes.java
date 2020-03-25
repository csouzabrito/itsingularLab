/**
 * 
 */
package com.br.itsingular.enums;

/**
 * @author dcarneiro
 *
 */
public enum TipoQualificacaoTestes {

	ADT(1),
	FTP(2),
	RAC_LÓGICO(3),
	REDAÇÃO(4),
	TÉCNICO(5),
	OUTROS(6);
	
	private Integer tipoQualificacaoTestes;

	private TipoQualificacaoTestes(Integer tipoqualificacaoTestes){
		this.tipoQualificacaoTestes = tipoqualificacaoTestes;
	
	}
	public Integer getTipoQualificacaoTestes() {
		return tipoQualificacaoTestes;
	}
	public void setTipoQualificacaoTestes(Integer tipoQualificacaoTestes) {
		this.tipoQualificacaoTestes = tipoQualificacaoTestes;
	}

}
