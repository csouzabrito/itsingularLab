package com.br.itsingular.messages;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Component
public class Messages{
	
	public static RedirectAttributes setMessage(final RedirectAttributes attributes, final String object, String message) {
		return attributes.addFlashAttribute(object, message);
	}
}
