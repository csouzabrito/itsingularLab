/**
 * 
 */
package com.br.itsingular.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

/**
 * @author dcarneiro
 *
 */
public class Utils {

	private static final String EMPTY = "";
	public static final String ERROR_DUPLICATE_KEY = "11000";
	//public static final String EMAIL_RH = "rh@itsingular.com.br";
	public static final String EMAIL_RH = "dcarneiro@itsingular.com.br";
	public static final String ASSUNTO_REQUISICAO_VAGA = "REQUISIÇÃO DE VAGAS";	
	
	public static <S> Boolean isEmptyOrNull(S entity) {
		return entity == null || entity.equals(EMPTY);
	}
	/**
	 * Formata a data no formato(ex): 01/jan/2020
	 * @param d
	 * @return
	 */
	public static String formatDate(LocalDate d) {
		if(Optional.ofNullable(d).isPresent()) {
			return d.format(DateTimeFormatter.ofPattern("dd/MMM/yyyy"));
		}
		return "<S/D>";
	}
}
