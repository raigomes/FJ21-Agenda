package br.com.caelum.mvc.logica;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class MostraContatoLogic implements Logica {

	private static final String JSP_PATH = "/WEB-INF/jsp/profile.jsp";
	
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		
		Connection connection = (Connection) request.getAttribute("conexao"); 
		ContatoDao dao = new ContatoDao(connection);
		Contato contato = dao.pesquisar(id);
		
		request.setAttribute("contato", contato);
		
		return JSP_PATH;
	}

}
