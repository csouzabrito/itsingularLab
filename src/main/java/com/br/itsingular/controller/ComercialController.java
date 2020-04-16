package com.br.itsingular.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.br.itsingular.entity.Comercial;
import com.br.itsingular.entity.Requisicao;
import com.br.itsingular.services.ComercialService;
import com.br.itsingular.services.RequisicaoFilter;
import com.br.itsingular.services.RequisicaoServices;


@Controller
@RequestMapping(value = "/comercial")
public class ComercialController {
	
	@Autowired
	private ComercialService comercialService;
	
	@Autowired
	private RequisicaoServices requisicaoServices;
	
	@Autowired
	private HttpSession session;
	
	
	@RequestMapping("/cadastro")
	public ModelAndView novo(){
		ModelAndView view = new ModelAndView("CadastroComercial");
		view.addObject(new Comercial());
		return view;
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvar(@Validated Comercial comercial, BindingResult result){
		if(result.hasErrors()){
			return new ModelAndView("CadastroComercial") ;
		}
		
		try{
			ModelAndView modelAndView = new ModelAndView("CadastroComercial");
			this.comercialService.salvar(comercial);
			modelAndView.addObject("message","Success");
			modelAndView.addObject("comercial", new Comercial());
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
	
	@PostMapping("/filtrar")
	public ModelAndView listar(Model model, @RequestParam final String filtro){
		
		List<Requisicao> requisicoes  = this.requisicaoServices.filtrarRequisicao(filtro);
		
//		view.addObject("filtro", new RequisicaoFilter());
		model.addAttribute("filtro", filtro);
		ModelAndView view = new ModelAndView("ViewComercial");
		view.addObject("requisicoes", requisicoes) ;
		return view;
	}
	
}
