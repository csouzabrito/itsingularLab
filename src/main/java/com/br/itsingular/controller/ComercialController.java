package com.br.itsingular.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.br.itsingular.model.Pessoa;
import com.br.itsingular.repository.PessoaFilter;
import com.br.itsingular.services.PessoaService;
import com.br.itsingular.utils.Utils;


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
			return "ComercialVagas";
		}
		
		try{
			this.pesssoaService.salvar(pessoa);
			attributes.addFlashAttribute("mensagem", "Pessoa cadastrada com Sucesso");
			return "redirect:/comercial/listar";
		}catch(IllegalArgumentException e){
			errors.rejectValue("dataVencimento", null, e.getMessage());
			return "ComercialVagas";
		}
	}
	
	@GetMapping(value = "/view")
	public ModelAndView main(Pessoa pessoa) {
		ModelAndView modelAndView = new ModelAndView("ComercialVagas");
		if(!Utils.isEmptyOrNull(pessoa)) {
			pessoa = new Pessoa();
		}	
		return modelAndView;
	}
	
	@GetMapping(value = "/listar")
	public ModelAndView search(@ModelAttribute("filtro") PessoaFilter filtro){
		
		List<Pessoa> pessoas = new ArrayList<>();
		
		if(Objects.isNull(filtro.getNome())) {
		   pessoas = pesssoaService.listarPessoas();	
		}else {
		   pessoas = pesssoaService.filtrarNomeComercial(filtro);
		}
		
		ModelAndView view = new ModelAndView("ComercialVagas");
		view.addObject("pessoas", pessoas) ;
		return view;
	}
	
}
