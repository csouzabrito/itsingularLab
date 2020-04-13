package com.br.itsingular.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.br.itsingular.entity.Curriculos;
import com.br.itsingular.entity.Tecnologias;
import com.br.itsingular.services.CadastrarCurriculosServices;
import com.br.itsingular.services.CadastrarTecnologiasServices;
import com.br.itsingular.utils.Utils;

import lombok.Getter;

@Controller
@RequestMapping(path = "/cadastrarCurriculos")
public class CadastrarCurriculosController {

	@Autowired
	private CadastrarTecnologiasServices cadastrarTecnologiasServices;

	@Autowired
	private CadastrarCurriculosServices cadastrarCurriculosServices;

	@Getter
	private List<Curriculos> listCurriculos;

	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ModelAndView init() {
		return addModel("");
	}

	public List<Tecnologias> listCursos() {
		return cadastrarTecnologiasServices.findCursos();
	}

	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public ModelAndView incluirCurriculos(@RequestParam("filePdf") MultipartFile pdf,
			@RequestParam("fileWord") MultipartFile word, @Valid Curriculos curriculos, BindingResult result)throws IOException {
		
		ModelAndView model = null;
		String mensagem = null;
		
		if (result.hasErrors()) {
			if (!result.getFieldError("fileWord").isBindingFailure()
					&& !result.getFieldError("filePdf").isBindingFailure()) {
				return model;
			}
		}
		if (!pdf.getContentType().equalsIgnoreCase("application/pdf")
				|| (!word.getContentType().contains("officedocument"))) {
			return model = addModel("upload");
		}
		try {
			curriculos.setFilePdf(new Binary(BsonBinarySubType.BINARY, pdf.getBytes()));
			curriculos.setFileWord(new Binary(BsonBinarySubType.BINARY, word.getBytes()));
			cadastrarCurriculosServices.save(curriculos);
			mensagem = "success";
		} catch (Exception e) {
			if(e.getMessage().contains(Utils.ERROR_DUPLICATE_KEY)) {
				mensagem = "duplicateInsert";
			} else {
				mensagem = "failed";
			}
		}
		return addModel(mensagem);

	}

	public List<Curriculos> findCurriculos() {
		return cadastrarCurriculosServices.findCurriculos();
	}

	private ModelAndView addModel(String mensagem) {
		ModelAndView model = new ModelAndView("/CadastrarCurriculos");
		listCurriculos = new ArrayList<Curriculos>();
		switch (mensagem) {
		case "success":
			model.addObject("curriculos", new Curriculos());
			model.addObject("listCursos", listCursos());
			listCurriculos.addAll(cadastrarCurriculosServices.findCurriculos());
			model.addObject("listCurriculos", listCurriculos);
			model.addObject("message", mensagem);
			break;
		case "":
			model.addObject("curriculos", new Curriculos());
			model.addObject("listCursos", listCursos());
			listCurriculos.addAll(cadastrarCurriculosServices.findCurriculos());
			model.addObject("listCurriculos", listCurriculos);
			break;
			
		default:
			model.addObject("listCursos", listCursos());
			listCurriculos.addAll(cadastrarCurriculosServices.findCurriculos());
			model.addObject("listCurriculos", listCurriculos);
			model.addObject("message", mensagem);
			break;
		}
		return model;
	}
}
