package br.com.caelum.servlet;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/adicionaContato")
public class AdicionaContatoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, 
					HttpServletResponse response) 
					throws ServletException, IOException {

		//Pega o writer
		PrintWriter out = response.getWriter();
		
		//Busca os elementos no formulário
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String endereco = request.getParameter("endereco");
		String dataEmTexto = request.getParameter("dataNascimento");
		
		//Converte data de String para Calendar
		Calendar dataNascimento = null;				
		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}		
		
		//Inicializa objeto Contato
		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setEmail(email);
		contato.setEndereco(endereco);
		contato.setDataNascimento(dataNascimento);
		
		//Insere Contato no Banco de Dados
		ContatoDao dao = new ContatoDao();
		dao.adiciona(contato);
		
		//Imprime resposta no writer
		out.println("<html>");
		out.println("<body>");
		out.println("Contato "+contato.getNome()+" adicionado com sucesso!");
		out.println("</body>");
		out.println("</html>");
	}

}
