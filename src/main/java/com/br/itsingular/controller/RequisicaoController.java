package com.br.itsingular.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.br.itsingular.entity.Requisicao;
import com.br.itsingular.entity.Requisitos;
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
	public ModelAndView addRequisicao(@Valid Requisicao requisicao, BindingResult result) {
		
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
	
	@RequestMapping(path = "/add")
	public ModelAndView addRequisitos(@Valid Requisicao requisicao, BindingResult result) {
		
		ModelAndView modelAndView = new ModelAndView("RequisicaoVagas");				
		
		List<Requisitos> listRequisitos = new ArrayList<>();
		
		listRequisitos.add(new Requisitos());
		modelAndView.addObject("listRequisitos", listRequisitos);
		
		modelAndView.addObject("error","error");
		return modelAndView;
	}
}
