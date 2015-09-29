package br.com.caelum.mvc.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;

public class RemoveContatoLogic implements Logica {	
	
	@Override
	public String executa(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {
		
		//Recupera ID do Request.
		long id = Long.parseLong(request.getParameter("id"));
		
		System.out.println("Excluindo contato...");
		
		//Chama método remove do DAO
		ContatoDao dao = new ContatoDao();
		dao.remove(id);
				
		System.out.println("Contato " + id + " removido!");
		
		//Retorna o nome da página do JSP para o ControllerServlet.
		return "mvc?logica=ListaContatosLogic";
	}

}
