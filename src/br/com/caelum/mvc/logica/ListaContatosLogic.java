package br.com.caelum.mvc.logica;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class ListaContatosLogic implements Logica {

	private static final String JSP_PATH = "/WEB-INF/jsp/lista-contatos.jsp";
	
	@Override
	public String executa(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		List<Contato> contatos = new ContatoDao().getLista();
		
		request.setAttribute("contatos", contatos);
		
		return JSP_PATH;
	}

}
