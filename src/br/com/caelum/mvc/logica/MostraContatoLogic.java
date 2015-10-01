package br.com.caelum.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class MostraContatoLogic implements Logica {

	private static final String JSP_PATH = "/WEB-INF/jsp/profile.jsp";
	
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		
		ContatoDao dao = new ContatoDao();
		Contato contato = dao.pesquisar(id);
		
		request.setAttribute("contato", contato);
		
		return JSP_PATH;
	}

}
