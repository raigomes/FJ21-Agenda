package br.com.caelum.mvc.logica;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;

public class RemoveContatoLogic implements Logica {	
	
	private static final String JSP_PATH = "mvc?logica=ListaContatosLogic";
	
	@Override
	public String executa(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		//Recupera ID do Request.
		long id = Long.parseLong(request.getParameter("id"));
		
		System.out.println("Excluindo contato...");
		
		//Chama método remove do DAO
		Connection connection = (Connection) request.getAttribute("conexao"); 
		ContatoDao dao = new ContatoDao(connection);
		dao.remove(id);
				
		System.out.println("Contato " + id + " removido!");
		
		//Retorna, para o ControllerServlet, a String com o caminho para a página do JSP.
		return JSP_PATH;
	}

}
