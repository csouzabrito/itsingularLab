/**
 * 
 */
package com.br.itsingular.utils;

/**
 * @author dcarneiro
 *
 */
public class TemplateEmailUtils {

	static StringBuffer sb = new StringBuffer();

	public static String criarTemplateEmail(int quantidade, String...is) {
	
		sb.append("<html lang=\"pt-BR\" class=\"aAX\">");
		sb.append("	<head>");
		sb.append("<meta http-equiv=\"Content-Type\"\"content=\"text/html; charset=UTF-8\">");
		sb.append("<meta name=\"viewport\" content=\"width=device-width\", initial-scale=1>");
		sb.append("<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">");
		sb.append("</head>");
		sb.append("<title>ITSINGULAR</title>");
		sb.append("<body style=\"margin:0; padding:0; background-color:#F2F2F2;\">");
		sb.append("<center>");
		sb.append("<tr>");
		sb.append("<td align=\"left\" valign=\"top\">");
		sb.append("<img src=\"https://ncdn0.infojobs.com.br/logos/2018/04/30/461110.jpg\" width=120 height=100>");          
		sb.append("</td>");
		sb.append("<td>");
		sb.append("<h3 align=\"center\">DADOS DA REQUISIÇÃO DE VAGA ABERTA</h3>");
		sb.append("</td> </BR></BR>");
		sb.append("<td>");
		sb.append("<h4 align=\"left\">Solicitante:" + is[1]+ "</h4>");
		sb.append("</td>");
		sb.append("<td>");
		sb.append("<h4 align=\"left\">Cliente:" + is[0]+ "</h4>");
		sb.append("</td>");	
		sb.append("<td>");
		sb.append("<h4 align=\"left\">Qtde Vagas: "+quantidade+"</h4>");
		sb.append("</td>");
		sb.append("<td>");
		sb.append("<h4 align=\"left\">Dt. Abertura:" + is[0]+ " </h4>");
		sb.append("</td>	");
		sb.append("</tr>");
		sb.append("</center>");
		sb.append("</body>");
		sb.append("</html>");
	
	return sb.toString();
	
	}
}
