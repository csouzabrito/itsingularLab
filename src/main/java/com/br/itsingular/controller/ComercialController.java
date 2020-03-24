package com.br.itsingular.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.br.itsingular.model.Pessoa;
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
	public String salvar(@Validated Pessoa pessoa, Errors errors, RedirectAttributes attributes ){
		if(errors.hasErrors()){
			return "CadastroPessoa";
		}
		
		try{
			this.pesssoaService.salvar(pessoa);
			attributes.addFlashAttribute("mensagem", "Pessoa cadastrada com Sucesso");
			return "redirect:/comercial/cadastro";
		}catch(IllegalArgumentException e){
			errors.rejectValue("dataVencimento", null, e.getMessage());
			return "CadastroPessoa";
		}
	}
	
	
}
