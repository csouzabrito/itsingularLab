package com.br.itsingular.utils;

import org.springframework.data.mongodb.core.query.Update;

import com.br.itsingular.entity.Funcionarios;

public class UpdateEmployeesConvert {

	public static Update updateDadosfuncionarios(Funcionarios f) {
		Update update = new Update();

		//Dados especificos do Profissional
		update.set("nome", f.getNome());
		update.set("rg", f.getRg());
		update.set("cpf", f.getCpf());
		update.set("dataNascimento", f.getDataNascimento());
		update.set("genero", f.getGenero());
		update.set("cor", f.getCor());
		update.set("idade", f.getIdade());
		update.set("naturalidade", f.getNaturalidade());
		update.set("estadoCivil", f.getEstadoCivil());
		update.set("quantidadeFilhos", f.getQuantidadeFilhos());
		update.set("grauInstrucao", f.getGrauInstrucao());
		
		//Dados de contato
		update.set("numeroCelular", f.getNumeroCelular());
		update.set("numeroTelefone", f.getNumeroTelefone());
		update.set("email", f.getEmail());
		
		//Dados para Contratacao
		update.set("departamento", f.getDepartamento());
		update.set("cargo", f.getCargo());
		update.set("nivelContratacao", f.getNivelContratacao());
		update.set("atuacao", f.getAtuacao());
		update.set("clienteParceiros", f.getClienteParceiros());
		update.set("gestores", f.getGestores());
		update.set("tipoContratacao", f.getTipoContratacao());
		update.set("remuneracao", f.getRemuneracao());
		update.set("valortransporte", f.getValorTransporte());
		update.set("valorVrVA", f.getValorVrVA());
		update.set("valorPlanoSaude", f.getValorPlanoSaude());
		update.set("valorAuxilioCreche", f.getValorAuxilioCreche());
		update.set("dataContratacao", f.getDataContratacao());
		update.set("dataFimContratacao", f.getDataFimContratacao());
		update.set("statusFuncionario", f.getStatusFuncionario());
		update.set("nivelFimContratacao", f.getNivelFimContratacao());
		
		//Dados do Logradouro 
		update.set("logradouro", f.getLogradouro());
		update.set("bairro", f.getBairro());
		update.set("estado", f.getEstado());
		update.set("numero", f.getNumero());
		update.set("complemento", f.getComplemento());
		update.set("cep", f.getCep());
		
		//Dados bancários
		update.set("tipoConta", f.getTipoConta());
		update.set("banco", f.getBanco());
		update.set("agencia", f.getAgencia());
		update.set("conta", f.getConta());
		
		//Se PJ, Dados da Empresa
		update.set("cnpj", f.getCnpj());
		update.set("nomeEmpresa", f.getNomeEmpresa());
		return update;
	}
}
