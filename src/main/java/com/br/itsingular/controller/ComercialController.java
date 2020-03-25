package com.br.itsingular.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.itsingular.model.Pessoa;
import com.br.itsingular.model.Requisicao;
import com.br.itsingular.services.PessoaService;


@Controller
@RequestMapping(value = "/comercial")
public class ComercialController {
	
	@Autowired
	private PessoaService pesssoaService;
	
	
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
	
	
	@GetMapping("/informacoes/{email}")
	public ModelAndView listarInfo(@ModelAttribute("email") final String filtro){
		
		List<Requisicao> requisicoes = this.pesssoaService.getInfoByFilter(filtro);
		
		ModelAndView view = new ModelAndView("ViewComercial");
		view.addObject("requisicoes", requisicoes) ;
		return view;
	}
}
