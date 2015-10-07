package br.com.caelum.mvc.logica;

import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class AlteraContatoLogic implements Logica {

	private static final String JSP_PATH = "mvc?logica=ListaContatosLogic";
	
	@Override
	public String executa(HttpServletRequest request, 
			HttpServletResponse response) throws Exception {

		Contato contato = new Contato();
		contato.setId(Long.parseLong(request.getParameter("id")));
		contato.setNome(request.getParameter("nome"));
		contato.setEmail(request.getParameter("email"));
		contato.setEndereco(request.getParameter("endereco"));
		
		String dataEmTexto = request.getParameter("dataNascimento");
		Calendar dataNascimento = null;				
		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(date);			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		contato.setDataNascimento(dataNascimento);
		
		System.out.println(contato);
		System.out.println("Alterando contato...");
		
		Connection connection = (Connection) request.getAttribute("conexao"); 
		ContatoDao dao = new ContatoDao(connection);
		dao.altera(contato);
		
		System.out.println("Contato "+contato.getNome()+" alterado!");
		
		return JSP_PATH;
	}

}
