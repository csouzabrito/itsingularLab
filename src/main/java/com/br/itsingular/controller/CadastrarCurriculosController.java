package com.br.itsingular.controller;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(path = "/cadastrarCurriculos")
public class CadastrarCurriculosController {

	@Autowired
	private HttpSession session;

	@Autowired
	private CadastrarTecnologiasServices cadastrarTecnologiasServices;

	@Autowired
	private CadastrarCurriculosServices cadastrarCurriculosServices;

	@RequestMapping(path = "/listar", method = RequestMethod.GET)
	public ModelAndView init(HttpServletRequest request, HttpServletResponse response) {
		log.info("------ Rastrabilidade. Iniciando funcionalidade de CadastrarCurriculos / init");
		ModelAndView model = getAddModel("init");
		return model;
	}

	@RequestMapping(path = "/add", method = RequestMethod.POST)
	public ModelAndView incluirCurriculos(@RequestParam("pdf") MultipartFile pdf,
			@RequestParam("word") MultipartFile word, @Valid Curriculos curriculos, BindingResult result)
			throws IOException {
		String mensagem = null;
		if (result.hasErrors()) {return getAddModel("result");}
		try {

			if (!Utils.isEmptyOrNull(session.getAttribute("curriculos"))) {
				if (pdf.getBytes().length > 0) {
					curriculos.setUploadDownloadPdf(new TipagemArquivosUpload(pdf.getOriginalFilename(), pdf.getName(),
							pdf.getContentType(), pdf.getBytes()));
					log.info("------ curriculo PDF realizando upload");
				} else {
					curriculos.setUploadDownloadPdf(
							((Curriculos) session.getAttribute("curriculos")).getUploadDownloadPdf());
				}
				if (word.getBytes().length > 0) {
					curriculos.setUploadDownloadWord(new TipagemArquivosUpload(word.getOriginalFilename(),
							word.getName(), word.getContentType(), word.getBytes()));
					log.info("------ curriculo Word realizando upload");
				} else {
					curriculos.setUploadDownloadWord(
							((Curriculos) session.getAttribute("curriculos")).getUploadDownloadWord());
				}
			} else {
				if (pdf.getBytes().length == 0 && word.getBytes().length == 0) {
					return getAddModel("validacaoUpload");
				}
				if ((pdf.getBytes().length > 0 && !pdf.getContentType().equalsIgnoreCase("application/pdf"))
						|| (word.getBytes().length > 0 && !((word.getContentType().contains("officedocument")
								|| (word.getContentType().contains("application/msword")))))) {
					return getAddModel("validacaoExtensaoUpload");
				}
				if (pdf.getBytes().length > 0) {
					curriculos.setUploadDownloadPdf(new TipagemArquivosUpload(pdf.getOriginalFilename(), pdf.getName(),
							pdf.getContentType(), pdf.getBytes()));
					log.info("------ curriculo PDF realizando upload");
				}
				if (word.getBytes().length > 0) {
					curriculos.setUploadDownloadWord(new TipagemArquivosUpload(word.getOriginalFilename(),
							word.getName(), word.getContentType(), word.getBytes()));
					log.info("------ curriculo Word realizando upload");
				}
			}
			if (Utils.isEmptyOrNull(curriculos.getDataUltimaAtualizacao())) {
				cadastrarCurriculosServices.insert(curriculos);
			} else {
				cadastrarCurriculosServices.removeAndInsertCurriculos(curriculos);
			}
			mensagem = "success";
		} catch (Exception e) {
			log.error("###### -- FALHA! Cause:" + e.getCause() + "--> Mensagem" + e.getMessage());
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

		FileCopyUtils.copy(infoCandidato.get().getUploadDownloadWord().getBitesArquivo(), response.getOutputStream());
		response.getOutputStream().flush();

	}

	@RequestMapping("/editar/{cpf}")
	public ModelAndView editar(@PathVariable("cpf") String cpf) {
		ModelAndView model = getAddModel("edit");
		Optional<Curriculos> list = cadastrarCurriculosServices.findCurriculoById(cpf);
		if (list.isPresent()) {
			model.addObject("curriculos", list.get());
			session.setAttribute("curriculos", list.get());
		}
		return model;
	}

	private ModelAndView getAddModel(String mensagem) {
		ModelAndView model = new ModelAndView("CadastrarCurriculos");
		session.removeAttribute("curriculos");
		model.addObject("login", session.getAttribute("login"));
		if (mensagem.equals("success") || mensagem.equals("init") || mensagem.equals("paginacao")) {
			model.addObject("curriculos", new Curriculos());
		}
		model.addObject("listCursos", cadastrarTecnologiasServices.findTecnologias());
		model = getListagem(model);
		if (!mensagem.equals("init") && !mensagem.equals("paginacao")) {
			model.addObject("message", mensagem);
		}
		return model;
	}

	private ModelAndView getListagem(final ModelAndView model) {
		model.addObject("listCurriculos", cadastrarCurriculosServices.findCurriculos());
		return model;

	}

	@RequestMapping("/paginacao/{page}/{size}")
	public ModelAndView listArticlesPageByPage(@PathVariable("page") int page, @PathVariable("size") int size) {
		ModelAndView model = getAddModel("paginacao");
		return model;
	}

}
