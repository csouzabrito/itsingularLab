package com.br.itsingular.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.itsingular.entity.Pessoa;
import com.br.itsingular.entity.Requisicao;
import com.br.itsingular.services.PessoaService;
import com.br.itsingular.services.RequisicaoFilter;
import com.br.itsingular.services.RequisicaoServices;


@Controller
@RequestMapping(value = "/comercial")
public class ComercialController {
	
	@Autowired
	private PessoaService pesssoaService;
	
	@Autowired
	private RequisicaoServices requisicaoServices;
	
	@Autowired
	private HttpSession session;
	
	
	@RequestMapping("/cadastro")
	public ModelAndView novo(){
		ModelAndView view = new ModelAndView("CadastroPessoa");
		view.addObject(new Pessoa());
		return view;
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvar(@Validated Pessoa pessoa, BindingResult result){
		if(result.hasErrors()){
			return new ModelAndView("CadastroPessoa") ;
		}
		
		try{
			ModelAndView modelAndView = new ModelAndView("CadastroPessoa");
			this.pesssoaService.salvar(pessoa);
			modelAndView.addObject("message","Success");
			modelAndView.addObject("pessoa", new Pessoa());
			return modelAndView;
		}catch(IllegalArgumentException e){
			throw new RuntimeException("Erro ao registrar o comercial");
		}
	}
	
	
	@GetMapping("/informacoes")
	public ModelAndView listarInfo(){
		
		Object email = session.getAttribute("email");
		
		List<Requisicao> requisicoes = this.requisicaoServices.getInfoByEmail(String.valueOf(email));
		
		ModelAndView view = new ModelAndView("ViewComercial");
		view.addObject("filtro", new RequisicaoFilter());
		view.addObject("requisicoes", requisicoes) ;
		return view;
	}
	
	@GetMapping("/filtrar")
	public ModelAndView listar(@ModelAttribute("filtro") final RequisicaoFilter filtro){
		
		List<Requisicao> requisicoes  = this.requisicaoServices.filtrarRequisicao(filtro);
		
		ModelAndView view = new ModelAndView("ViewComercial");
		view.addObject("filtro", new RequisicaoFilter());
		view.addObject("requisicoes", requisicoes) ;
		return view;
	}
	
}
