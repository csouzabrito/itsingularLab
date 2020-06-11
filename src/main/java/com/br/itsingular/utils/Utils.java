/**
 * 
 */
package com.br.itsingular.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

/**
 * @author dcarneiro
 *
 */
public class Utils {

	public static final String EMPTY = "";
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
	
	public static String toLocalDateFormat(LocalDate date) {
		if(Optional.ofNullable(date).isPresent()) {
			return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		}
		return "<S/D>";
	}
	
	
	public static <T> Page<T> toPageable(final List<T> list) {
		
		final Page<T> pageble = new PageImpl<>(list);	
		
		return pageble;
	}
}