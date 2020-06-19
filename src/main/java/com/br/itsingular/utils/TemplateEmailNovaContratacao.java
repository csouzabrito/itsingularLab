/**
 * 
 */
package com.br.itsingular.utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author dcarneiro
 *
 */
public class TemplateEmailNovaContratacao {

	static StringBuffer sb = new StringBuffer();

	public static String criarTemplateEmail(final String nome, final String departamento, final String gestor,
			final String cliente, final LocalDate dataInicio) {

		sb.append("	<!DOCTYPE html>");
		sb.append("<html lang=\"en\" xmlns=\"http://www.w3.org/1999/xhtml\"");
		sb.append("xmlns:v=\"urn:schemas-microsoft-com:vml\"");
		sb.append("xmlns:o=\"urn:schemas-microsoft-com:office:office\">");
		sb.append("<head>");
		sb.append(" <meta charset=\"utf-8\">");
		sb.append(" <meta name=\"viewport\" content=\"width=device-width\"> ");
		sb.append("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\"> ");
		sb.append("<meta name=\"x-apple-disable-message-reformatting\"> ");
		sb.append(" <style>");
		sb.append("    html,");
		sb.append("    body {");
		sb.append("       margin: 0 auto !important;");
		sb.append("      padding: 0 !important;");
		sb.append("     height: 100% !important;");
		sb.append("      width: 100% !important;");
		sb.append("   }");
		sb.append("   * {");
		sb.append("    -ms-text-size-adjust: 100%;");
		sb.append("   -webkit-text-size-adjust: 100%;");
		sb.append(" }");
//		sb.append(" div[style*=\"margin: 16px 0\"] {");
//		sb.append(" margin: 0 !important;\");");
//		sb.append("}");
//		sb.append(".tabelaProduto:nth-child(odd) {");
//		sb.append("background-color:#f5f5f5; ");
//		sb.append("}");
//		sb.append(".tabelaProduto:nth-child(even) {");
//		sb.append(" background-color:#ebebeb; ");
//		sb.append("  }");
//		sb.append("  table,");
//		sb.append("  td {");
//		sb.append("     mso-table-lspace: 0pt !important;");
//		sb.append("    mso-table-rspace: 0pt !important;");
//		sb.append(" }");
//		sb.append(" table {");
//		sb.append("    border-spacing: 0 !important;");
//		sb.append("    border-collapse: collapse !important;");
//		sb.append("   table-layout: fixed !important;");
//		sb.append("  margin: 0 auto !important;");
//		sb.append("}");
//		sb.append(" table table table {");
//		sb.append("     table-layout: auto;");
//		sb.append(" }");
//		sb.append(" img {");
//		sb.append("     -ms-interpolation-mode:bicubic;");
//		sb.append(" }");
//		sb.append("*[x-apple-data-detectors], ");
//		sb.append(".x-gmail-data-detectors,  ");
//		sb.append(".x-gmail-data-detectors *,");
//		sb.append(".aBn {");
//		sb.append("   border-bottom: 0 !important;");
//		sb.append("    cursor: default !important;");
//		sb.append("    color: inherit !important;");
//		sb.append("    text-decoration: none !important;");
//		sb.append("    font-size: inherit !important;");
//		sb.append("   font-family: inherit !important;");
//		sb.append("   font-weight: inherit !important;");
//		sb.append("   line-height: inherit !important;");
//		sb.append("  }");
//		sb.append("    .a6S {");
//		sb.append("         display: none !important;");
//		sb.append("         opacity: 0.01 !important;");
//		sb.append("     }");
//		sb.append("     img.g-img + div {");
//		sb.append("         display: none !important;");
//		sb.append("      }");
//		sb.append("     .button-link {");
//		sb.append("          text-decoration: none !important;");
//		sb.append("      }");
//		sb.append("      @media only screen and (min-device-width: 320px) and (max-device-width: 374px) {");
//		sb.append("  .email-container {");
//		sb.append("     min-width: 320px !important;");
//		sb.append(" }");
//		sb.append("}");
//		sb.append("@media only screen and (min-device-width: 375px) and (max-device-width: 413px) {");
//		sb.append(".email-container {");
//		sb.append(" min-width: 375px !important;");
//		sb.append("  }");
//		sb.append(" }");
//		sb.append("  @media only screen and (min-device-width: 414px) {");
//		sb.append("       .email-container {");
//		sb.append("           min-width: 414px !important;");
//		sb.append("   }");
//		sb.append("  }");
//
//		sb.append("  </style>");
//		sb.append(" <style>");
//
//		sb.append(".button-td,");
//		sb.append(".button-a {");
//		sb.append("   transition: all 100ms ease-in;");
//		sb.append(" }");
//		sb.append(" .button-td:hover,");
//		sb.append("  .button-a:hover {");
//		sb.append(" background: #555555 !important;");
//		sb.append("  border-color: #555555 !important;");
//		sb.append("}");
//
//		sb.append("@media screen and (max-width: 640px) {");
//		sb.append("  .email-container p {");
//		sb.append(" font-size: 17px !important;");
//		sb.append("  }");
//		sb.append("   }");
//		sb.append(" </style>");
//		sb.append("	</head>");
		sb.append("	<body width=\"100%\" bgcolor=\"#ffffff\" style=\"margin: 0; mso-line-height-rule: exactly;\">");
		sb.append("    <center style=\"width: 100%; background: #ffffff; text-align: left;\">");
		sb.append(
				"  <div style=\"display: none; font-size: 1px; line-height: 1px; max-height: 0px; max-width: 0px; opacity: 0; overflow: hidden; mso-hide: all; font-family: Arial, sans-serif;\">");
		sb.append(" </div>");
		sb.append(
				" <div style=\"display: none; font-size: 1px; line-height: 1px; max-height: 0px; max-width: 0px; opacity: 0; overflow: hidden; mso-hide: all; font-family: Arial, sans-serif;\">");
		sb.append(
				"&zwnj;&nbsp;&zwnj;&nbsp;&zwnj;&nbsp;&zwnj;&nbsp;&zwnj;&nbsp;&zwnj;&nbsp;&zwnj;&nbsp;&zwnj;&nbsp;&zwnj;&nbsp;&zwnj;&nbsp;&zwnj;&nbsp;&zwnj;&nbsp;&zwnj;&nbsp;&zwnj;&nbsp;&zwnj;&nbsp;&zwnj;&nbsp;&zwnj;&nbsp;&zwnj;&nbsp;");
		sb.append(" </div>");
		sb.append(" <div style=\"max-width: 640px; margin: auto;\" class=\"email-container\">");
		sb.append(
				" <table role=\"presentation\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" align=\"center\" width=\"100%\" style=\"max-width: 640px;\">");
		sb.append("  <tr>");
		sb.append("  <td align=\"left\" valign=\"top\">");
		sb.append("<img src=\"https://ncdn0.infojobs.com.br/logos/2018/04/30/461110.jpg\" width=110 height=70>");
		sb.append("</td>");
		sb.append("   </tr>");
		sb.append(" </table>");
		sb.append(
				" <table role=\"presentation\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" align=\"center\" width=\"100%\" style=\"max-width: 640px; border: 1px solid #d8d8d8;\">");
		sb.append(" <tr>");
		sb.append(" <td bgcolor=\"#ffffff\">");
		sb.append(" <table role=\"presentation\" cellspacing=\"0\" cellpadding=\"0\" border=\"0\" width=\"100%\">");
		sb.append("  <tr>");
		sb.append("  <td style=\"padding: 40px 25px;\">");
		sb.append(
				"<P style=\"text-align:center;margin: 0;  font-family: Arial, sans-serif; font-size: 20px; line-height: 140%; color: #3e4049;\">NOVO PROFISSIONAL IT SINGULAR </P>");
		sb.append(
				"<P style=\"margin: 0;  font-family: Arial, sans-serif; font-size: 16px; line-height: 140%; color: #3e4049;\"></P><BR>");
		sb.append(
				"<P style=\"margin: 0;  font-family: Arial, sans-serif; font-size: 16px; line-height: 140%; color: #3e4049;\">Nome do Funcionário: "
						+ nome + "</P><BR>");
		sb.append(
				"<P style=\"margin: 0;  font-family: Arial, sans-serif; font-size: 16px; line-height: 140%; color: #3e4049;\">Departamento: "
						+ departamento + "</P><BR>");
		sb.append(
				"<P style=\"margin: 0;  font-family: Arial, sans-serif; font-size: 16px; line-height: 140%; color: #3e4049;\">Gestor Direto: "
						+ gestor + "</P><BR>");
		sb.append(
				"<P style=\"margin: 0;  font-family: Arial, sans-serif; font-size: 16px; line-height: 140%; color: #3e4049;\">Cliente: "
						+ cliente + "</P><BR>");
		sb.append(
				"<P style=\"margin: 0;  font-family: Arial, sans-serif; font-size: 16px; line-height: 140%; color: #3e4049;\">Dt. de Início: "
						+ dataInicio.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) + "</P><BR>");
		sb.append("   </td>");
		sb.append("  </tr>");
		sb.append(" </table>");
		sb.append(" </td>");
		sb.append("  </tr>");
		sb.append("    </table> ");
		sb.append("</div>");
		sb.append("	    </center>");
		sb.append("	</body>");
		sb.append("	</html>");

		return sb.toString();

	}
}
