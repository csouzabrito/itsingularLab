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
import com.br.itsingular.utils.PageWrapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/recursos-humanos")
public class RHController {
	
	@Autowired
	private RHSrevice rhService;
	
	@Autowired
	private CadastrarCurriculosServices curriculoService;

	@RequestMapping("/view")
	public ModelAndView novo(Model model, @RequestParam(name = "page", defaultValue = "0") final int page, @RequestParam(name = "size", defaultValue = "5") final int size){
		
		ModelAndView view = new ModelAndView("ViewRH");
		
		final Page<Requisicao> vagas = this.rhService.findRequisicao(page, size);
		PageWrapper<Requisicao> vagasPage = new PageWrapper<Requisicao>(vagas, "/recursos-humanos/view");
		
		view.addObject("vagas", vagas);
		model.addAttribute("vagas", vagas.getContent());
		model.addAttribute("page", vagasPage);
		
		return view;
	}
	
	@GetMapping("/vagas")
	public ModelAndView listarInfo(@RequestParam(name = "page", defaultValue = "0") final int page, @RequestParam(name = "size", defaultValue = "5") final int size){

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
	public ModelAndView listar(Model model, @RequestParam final String filtro, @RequestParam(name = "page", defaultValue = "0") final int page, @RequestParam(defaultValue = "5") final int size){
		
		Page<Requisicao> vagas = null;
		
		if(StringUtils.isBlank(filtro)) {
		   vagas = this.rhService.findRequisicao(page, size);
		}else {
		   vagas = this.rhService.filtrarVagas(filtro, page, size);
		}
		
		PageWrapper<Requisicao> vagasPage = new PageWrapper<Requisicao>(vagas, "/recursos-humanos/vagas/pesquisar");
		ModelAndView view = new ModelAndView("ViewRH");
		view.addObject("vagas", vagas) ;
		model.addAttribute("filtro", filtro);
		model.addAttribute("vagas", vagas.getContent());
		model.addAttribute("page", vagasPage);
		
		return view;
	}
}
