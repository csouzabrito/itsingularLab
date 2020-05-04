package com.br.itsingular.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.br.itsingular.entity.Empresa;
import com.br.itsingular.services.EmpresaServices;
import com.br.itsingular.utils.Utils;

@Controller
@RequestMapping(value = "/empresa")
public class EmpresaController {

	@Autowired
	private EmpresaServices empresaServices;

	@RequestMapping(value = "/abrir", method = RequestMethod.GET)
	public ModelAndView main(Empresa empresa) {
		ModelAndView modelAndView = new ModelAndView("CadastroEmpresa");
		if(!Utils.isEmptyOrNull(empresa)) {
			empresa = new Empresa();
		}	
		return modelAndView;
	}
	
	@RequestMapping(path = "/addEmpresa", method = RequestMethod.POST)
	public ModelAndView add(@Valid Empresa empresa, BindingResult result) {

		if (result.hasErrors()) {
			return main(null);
		}
		ModelAndView modelAndView = new ModelAndView("Empresa");
		if (!Utils.isEmptyOrNull(empresaServices.save(empresa))) {
			modelAndView.addObject("message","Success");
			modelAndView.addObject("Empresa", new Empresa());
			return modelAndView;
		}
		modelAndView.addObject("error","error");
		return modelAndView;
		
	}
	
	@RequestMapping(path = "/findEmpresa", method = RequestMethod.GET)
	public ModelAndView list(BindingResult result) {

		if (result.hasErrors()) {
			return main(null);
		}
		ModelAndView modelAndView = new ModelAndView("ConsultaEmpresa");
		Page<Empresa> list = empresaServices.list(); // aqui parece não utilizar esta variavel de retorno da consulta
		if (!Utils.isEmptyOrNull(list.getContent())) {
			modelAndView.addObject("message","Success");
			modelAndView.addObject("Empresa", new Empresa());
			return modelAndView;
		}
		modelAndView.addObject("error","error");
		return modelAndView;
		
	}

	@GetMapping("/listar/{cnpj}")
	public ModelAndView listarInfo(@ModelAttribute("cnpj") final String filtro){
		
		Page<Empresa> empresas = this.empresaServices.getInfoByFilter(filtro);
		
		ModelAndView view = new ModelAndView("ViewEmpresa");
		view.addObject("empresas", empresas) ;
		return view;
	}
}
