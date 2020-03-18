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
	
	public static <S> Boolean isEmptyOrNull(S entity) {
		return entity == null || entity.equals(EMPTY);
	}
}
