/**
 * 
 */
package com.br.itsingular.configuration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author dcarneiro
 *
 */
@ControllerAdvice
public class GlobalException {

	@ExceptionHandler(MaxUploadSizeExceededException.class)
	public ModelAndView handleMaxSizeException(MaxUploadSizeExceededException exc, HttpServletRequest request,
			HttpServletResponse response) {

		ModelAndView modelAndView = (ModelAndView) request.getSession().getAttribute("curriculos");
		modelAndView.addObject("message","tamanhoNSuportado");
		return modelAndView;
	}
}
