package com.br.itsingular.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.itsingular.model.Grafico;

@Controller
@RequestMapping(value = "/graficos")
public class GraficoController {

	@RequestMapping("/candidatos")
	public ModelAndView getGrafico() {
		
		ModelAndView view = new ModelAndView("ViewGrafico");
		view.addObject(new Grafico());
		return view;
	}
}
