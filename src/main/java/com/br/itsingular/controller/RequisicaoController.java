package com.br.itsingular.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.br.itsingular.model.Requisicao;
import com.br.itsingular.services.RequisicaoServices;
import com.br.itsingular.utils.Utils;

@Controller
@RequestMapping(value = "/requisicao")
public class RequisicaoController {

	@Autowired
	private RequisicaoServices requisicaoServices;

	@RequestMapping(value = "/abrir", method = RequestMethod.GET)
	public ModelAndView main(Requisicao requisicao) {
		ModelAndView modelAndView = new ModelAndView("RequisicaoVagas");
		if(!Utils.isEmptyOrNull(requisicao)) {
			requisicao = new Requisicao();
		}	
		return modelAndView;
	}
	
	@RequestMapping(path = "/addRequisicao", method = RequestMethod.POST)
	public ModelAndView add(@Valid Requisicao requisicao, BindingResult result) {
		
		if (result.hasErrors()) {
			return main(null);
		}
		ModelAndView modelAndView = new ModelAndView("RequisicaoVagas");
		if (!Utils.isEmptyOrNull(requisicaoServices.salvarRequisicao(requisicao))) {
			modelAndView.addObject("message","Success");
			modelAndView.addObject("requisicao", new Requisicao());
			return modelAndView;
		}
		modelAndView.addObject("error","error");
		return modelAndView;
		
	}
}
