package com.br.itsingular.controller;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.br.itsingular.entity.Curriculos;
import com.br.itsingular.entity.TipagemArquivosUpload;
import com.br.itsingular.services.CadastrarCurriculosServices;
import com.br.itsingular.services.CadastrarTecnologiasServices;
import com.br.itsingular.utils.Utils;

@Controller
@RequestMapping(path = "/cadastrarCurriculos")
public class CadastrarCurriculosController {

	@Autowired
	private CadastrarTecnologiasServices cadastrarTecnologiasServices;

	@Autowired
	private CadastrarCurriculosServices cadastrarCurriculosServices;

	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	@Cacheable(value = "listarTecnologias")
	public ModelAndView init(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView model = getAddModel("init");
		request.getSession().invalidate();
		request.getSession().setAttribute("curriculos", model);
		return model;
	}

	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public ModelAndView incluirCurriculos(@RequestParam("pdf") MultipartFile pdf,
			@RequestParam("word") MultipartFile word, @Valid Curriculos curriculos, BindingResult result)
			throws IOException {

		String mensagem = null;

		if (result.hasErrors()) {
			return getAddModel("result");
		}

		if (!pdf.getContentType().equalsIgnoreCase("application/pdf")
				|| (!word.getContentType().contains("officedocument"))) {
			return getAddModel("upload");
		}
		try {

			curriculos.setUploadDownloadPdf(new TipagemArquivosUpload(pdf.getOriginalFilename(), pdf.getName(),
					pdf.getContentType(), pdf.getBytes()));
			curriculos.setUploadDownloadWord(new TipagemArquivosUpload(word.getOriginalFilename(), word.getName(),
					word.getContentType(), word.getBytes()));
			cadastrarCurriculosServices.save(curriculos);
			mensagem = "success";
		} catch (Exception e) {
			if (e.getMessage().contains(Utils.ERROR_DUPLICATE_KEY)) {
				mensagem = "duplicateInsert";
			} else {
				mensagem = "failed";
			}
		}
		return getAddModel(mensagem);
	}

	@RequestMapping("/viewPdf/{cpf}")
	public void viewPdf(@PathVariable("cpf") String cpf, HttpServletRequest req, HttpServletResponse response)
			throws IOException {
	
		Optional<Curriculos> infoCandidato = Optional
				.ofNullable(cadastrarCurriculosServices.findCurriculoById(cpf).get());
			response.setContentType(infoCandidato.get().getUploadDownloadPdf().getType() + ";charset=UTF-8");
			response.setContentLength(infoCandidato.get().getUploadDownloadPdf().getBitesArquivo().length);
			response.setHeader("Content-Disposition", "attachment; charset=utf-8; filename=\""
					+ infoCandidato.get().getUploadDownloadPdf().getNameArquivo() + "\"");
			
			FileCopyUtils.copy(infoCandidato.get().getUploadDownloadPdf().getBitesArquivo(), response.getOutputStream());
			response.getOutputStream().flush();
		
	}

	@RequestMapping("/viewWord/{cpf}")
	public void viewWord(@PathVariable("cpf") String cpf, HttpServletRequest req, HttpServletResponse response)
			throws IOException {
	
		Optional<Curriculos> infoCandidato = Optional
				.ofNullable(cadastrarCurriculosServices.findCurriculoById(cpf).get());

			response.setContentType(infoCandidato.get().getUploadDownloadWord().getType() + ";charset=UTF-8");
			response.setContentLength(infoCandidato.get().getUploadDownloadWord().getBitesArquivo().length);
			response.setHeader("Content-Disposition", "attachment; charset=utf-8; filename=\""
					+ infoCandidato.get().getUploadDownloadWord().getNameArquivo() + "\"");

			FileCopyUtils.copy(infoCandidato.get().getUploadDownloadWord().getBitesArquivo(),
					response.getOutputStream());
			response.getOutputStream().flush();

	}

	private ModelAndView getAddModel(String mensagem) {
		ModelAndView model = new ModelAndView("/CadastrarCurriculos");
		model.addObject("listCursos", cadastrarTecnologiasServices.findTecnologias());
		model.addObject("listCurriculos", cadastrarCurriculosServices.findCurriculos());
		if (!mensagem.equals("init")) {
			model.addObject("message", mensagem);
		}
		if (mensagem.equals("success") || mensagem.equals("init")) {
			model.addObject("curriculos", new Curriculos());
		}
		return model;
	}

}
