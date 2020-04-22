package com.br.itsingular.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.br.itsingular.entity.Curriculos;
import com.br.itsingular.entity.Requisicao;
import com.br.itsingular.services.CadastrarCurriculosServices;
import com.br.itsingular.services.RHSrevice;

@Controller
@RequestMapping(value = "/recursos-humanos")
public class RHController {
	
	@Autowired
	private RHSrevice rhService;
	
	@Autowired
	private CadastrarCurriculosServices curriculoService;

	@RequestMapping("/view")
	public ModelAndView novo(@RequestParam(defaultValue = "0") final int page, @RequestParam(defaultValue = "15") final int size){
		
		ModelAndView view = new ModelAndView("ViewRH");
		
		final Page<Requisicao> vagas = this.rhService.findRequisicao(page, size);
		
		view.addObject("vagas", vagas) ;
		
		return view;
	}
	
	@GetMapping("/vagas")
	public ModelAndView listarInfo(@RequestParam(defaultValue = "0") final int page, @RequestParam(defaultValue = "15") final int size){

	final Page<Requisicao> vagas = this.rhService.findRequisicao(page, size);
		
		ModelAndView view = new ModelAndView("ViewRH");
		view.addObject("vagas", vagas) ;
		return view;
	}
	
	@ResponseBody
	@GetMapping("/vagas/{id}")	
	public List<Curriculos> find(Model model, @PathVariable("id") final Requisicao vaga) {
		
		List<Curriculos> curriculos = this.curriculoService.findByIds(vaga);
		
		model.addAttribute("curriculos", curriculos);
		return curriculos;
		
	}
	
	@GetMapping("/vagas/pesquisar")
	public ModelAndView listar(Model model, @RequestParam final String filtro, @RequestParam(defaultValue = "0") final int page, @RequestParam(defaultValue = "15") final int size){
		
		Page<Requisicao> vagas = null;
		
		if(StringUtils.isBlank(filtro)) {
		   vagas = this.rhService.findRequisicao(page, size);
		}else {
		   vagas = this.rhService.filtrarVagas(filtro, page, size);
		}
		model.addAttribute("filtro", filtro);
		ModelAndView view = new ModelAndView("ViewRH");
		view.addObject("vagas", vagas) ;
		return view;
	}
}
