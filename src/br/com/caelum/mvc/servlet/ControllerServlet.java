package br.com.caelum.mvc.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.mvc.logica.Logica;

/*
 * - Método service recebe o nome da classe que vai executar a lógica de negócio; 
 * - Essa classe implementa a interface Logica e é instanciada através do tipo Class;
 * - O método executa retorna o nome do JSP que vai exibir a resposta ao usuário;
 * - O RequestDispatcher encaminha a resposta ao JSP correspondente;
 * 
 * => ControllerServlet e Logica são um exemplo de implementação do pattern Front Controller. 
 */

@WebServlet("/mvc")
public class ControllerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, 
					HttpServletResponse response) 
					throws ServletException, IOException {
		
		String parametro = request.getParameter("logica");
		String nomeDaClasse = "br.com.caelum.mvc.logica." + parametro;
		
		try {
			Class<?> classe = Class.forName(nomeDaClasse);
			
			Logica logica = (Logica) classe.newInstance();
			String pagina = logica.executa(request, response);
			
			RequestDispatcher rd = request.getRequestDispatcher(pagina);
			rd.forward(request, response);
		}
		catch(Exception e) {
			throw new ServletException("A logica de negócios causou uma exceção.", e);
		}
	}
	
}
