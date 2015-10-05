package br.com.caelum.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdicionaContatoLogic implements Logica {

	private static final String JSP_PATH = "/WEB-INF/jsp/adiciona-contato.jsp";
	
	@Override
	public String executa(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		return JSP_PATH;
	}

}
