package com.br.itsingular.services;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.br.itsingular.entity.Pessoa;

@Controller
@RequestMapping(value = "/recursos-humanos")
public class RHSrevice {
	
	@RequestMapping("/view")
	public ModelAndView novo(){
		ModelAndView view = new ModelAndView("ViewRH");
		view.addObject(new Pessoa());
		return view;
	}

}
