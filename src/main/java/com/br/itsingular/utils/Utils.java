/**
 * 
 */
package com.br.itsingular.utils;

/**
 * @author dcarneiro
 *
 */
public class Utils {

	private static final String EMPTY = "";
	//public static final String EMAIL_RH = "rh@itsingular.com.br";
	public static final String EMAIL_RH = "dcarneiro@itsingular.com.br";
	public static final String ASSUNTO_REQUISICAO_VAGA = "REQUISIÇÃO DE VAGAS";	
	
	public static <S> Boolean isEmptyOrNull(S entity) {
		return entity == null || entity.equals(EMPTY);
	}
}
