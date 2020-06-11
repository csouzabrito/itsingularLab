package com.br.itsingular.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.br.itsingular.entity.Curriculos;
import com.br.itsingular.entity.Login;
import com.br.itsingular.entity.Requisicao;
import com.br.itsingular.services.CadastrarCurriculosServices;
import com.br.itsingular.services.RHSrevice;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(value = "/recursos-humanos")
public class RHController {
	
	@Autowired
	private RHSrevice rhService;
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private CadastrarCurriculosServices curriculoService;

	@RequestMapping("/view")
	public ModelAndView novo(){
		ModelAndView view = new ModelAndView("ViewRH");
		view.addObject("vagas", this.rhService.findRequisicao());
		view.addObject("login", session.getAttribute("login"));
		return view;
	}
	
	@GetMapping("/vagas")
	public ModelAndView listarInfo(){
	
	log.info("Listando vagas {}");
		ModelAndView view = new ModelAndView("ViewRH");
		view.addObject("vagas", this.rhService.findRequisicao()) ;
		return view;
	}
	
	@ResponseBody
	@GetMapping("/vagas/{id}")
	public List<Curriculos> find(Model model, @PathVariable("id") final Requisicao vaga) {
		log.info("Consultando vagas{}");
		List<Curriculos> curriculos = this.curriculoService.findByIds(vaga);
		
		model.addAttribute("curriculos", curriculos);
		return curriculos;
	}
	@GetMapping("/responsavel/{id}")
	public ModelAndView responsavelPelaRequisicao(Model model, @PathVariable("id") final Requisicao vaga) {
		ModelAndView view = new ModelAndView("ViewRH");
		Login login = (Login) session.getAttribute("login");
		this.rhService.updateResposavelRequisicao(vaga, login.getName());
		view.addObject("vagas", this.rhService.findRequisicao()) ;
		view.addObject("login", login);
		return view;
	}
	
	@GetMapping("/concluirTarefa/{id}")
	public ModelAndView concluirRequisicao(Model model, @PathVariable("id") final Requisicao vaga) {
		ModelAndView view = new ModelAndView("ViewRH");
		Login login = (Login) session.getAttribute("login");
		this.rhService.updateConcluirTarefa(vaga, login.getName());
		view.addObject("vagas", this.rhService.findRequisicao()) ;
		view.addObject("login", login);
		return view;
	}
	
	
	
	@GetMapping("/vagas/pesquisar")
	public ModelAndView listar(Model model, @RequestParam final String filtro){
		ModelAndView view = new ModelAndView("ViewRH");
		List<Requisicao> vagas = null;
		
		if(StringUtils.isBlank(filtro)) {
		   vagas = this.rhService.findRequisicao();
		}else {
		   vagas = this.rhService.filtrarVagas(filtro);
		}
		view.addObject("vagas", vagas);
		model.addAttribute("filtro", filtro);
		view.addObject("login", session.getAttribute("login"));
		return view;
	}
}
