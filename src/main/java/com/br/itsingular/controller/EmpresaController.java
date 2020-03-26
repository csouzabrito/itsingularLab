package com.br.itsingular.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.br.itsingular.entity.Empresa;
import com.br.itsingular.repository.EmpresaRepository;
import com.br.itsingular.utils.Utils;

@Controller
@RequestMapping(value = "/empresa")
public class EmpresaController {

	@Autowired
	private EmpresaRepository EmpresaServices;

	@RequestMapping(value = "/abrir", method = RequestMethod.GET)
	public ModelAndView main(Empresa Empresa) {
		ModelAndView modelAndView = new ModelAndView("CadastroEmpresa");
		if(!Utils.isEmptyOrNull(Empresa)) {
			Empresa = new Empresa();
		}	
		return modelAndView;
	}
	
	@RequestMapping(path = "/addEmpresa", method = RequestMethod.POST)
	public ModelAndView add(@Valid Empresa Empresa, BindingResult result) {

		if (result.hasErrors()) {
			return main(null);
		}
		ModelAndView modelAndView = new ModelAndView("CadastroEmpresa");
		if (!Utils.isEmptyOrNull(EmpresaServices.save(Empresa))) {
			modelAndView.addObject("message","Success");
			modelAndView.addObject("Empresa", new Empresa());
			return modelAndView;
		}
		modelAndView.addObject("error","error");
		return modelAndView;
		
	}
	
	@RequestMapping(path = "/findEmpresa", method = RequestMethod.GET)
	public ModelAndView find(@Valid Empresa Empresa, BindingResult result) {

		if (result.hasErrors()) {
			return main(null);
		}
		ModelAndView modelAndView = new ModelAndView("ConsultaEmpresa");
		if (!Utils.isEmptyOrNull(EmpresaServices.findAll())) {
			modelAndView.addObject("message","Success");
			modelAndView.addObject("Empresa", new Empresa());
			return modelAndView;
		}
		modelAndView.addObject("error","error");
		return modelAndView;
		
	}
}
