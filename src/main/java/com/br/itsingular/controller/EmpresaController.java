package com.br.itsingular.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.br.itsingular.dto.EmpresaDTO;
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

	@RequestMapping(value = "/findEmpresa", method = RequestMethod.GET)
	public ModelAndView list() {

		ModelAndView modelAndView = new ModelAndView("ViewEmpresa");
		Page<Empresa> empresas = empresaServices.list();
		if (!Utils.isEmptyOrNull(empresas.getContent())) {
			modelAndView.addObject("message","Success");
			modelAndView.addObject("empresas", empresas.getContent());
			return modelAndView;
		}
		modelAndView.addObject("error","error");
		return modelAndView;
		
	}

	@RequestMapping
	public ModelAndView listarInfo(@ModelAttribute("filtro") final EmpresaDTO filtro){
		
		Empresa empresas = this.empresaServices.getInfoByFilter(filtro);
//		this.empresaServices.ge
		
		ModelAndView view = new ModelAndView("ViewEmpresa");
		view.addObject("empresas", empresas) ;
		return view;
	}
//	
//	@PostMapping("/listarEmpresas")
//	public String list(@Validated EmpresaDTO dto, RedirectAttributes attributes, HttpSession session){
//		
//		final String page = "ConsultaEmpresa";
//		
//		EmpresaDTO result = this.empresaServices.findEmpresa(dto);
//		
//		if(Objects.nonNull(result)) {
//			 session.setAttribute("name", result.getFantasia());
//			 return "redirect:/empresa/empresas";
//		}else {
//			Messages.setMessage(attributes, "message", "Erro ao consultar, tente novamente");
//		}
//		
//		return page;
//	}
}
