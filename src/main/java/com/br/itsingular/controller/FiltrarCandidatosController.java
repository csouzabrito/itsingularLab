package com.br.itsingular.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.itsingular.entity.Curriculos;
import com.br.itsingular.services.FiltrarCandidatosService;

@Controller
@RequestMapping(path = "/filtrarCandidatos")
public class FiltrarCandidatosController {
	
	@Autowired
	private FiltrarCandidatosService filtrarCandidatoService;

	@Autowired
	private HttpSession session;
	
	@RequestMapping(path = "/iniciarFiltroCandidatos")
	public ModelAndView init() {
		ModelAndView model = new ModelAndView("FiltroCandidatos");
		model.addObject("curriculos", new Curriculos());
		model.addObject("listarCandidatos", filtrarCandidatoService.getCandidatos());
		model.addObject("login", session.getAttribute("login"));
		return model;
	}
	
}
