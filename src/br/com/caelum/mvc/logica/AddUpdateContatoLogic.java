package br.com.caelum.mvc.logica;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;

public class AddUpdateContatoLogic implements Logica {

	private static final String JSP_PATH = "mvc?logica=ListaContatosLogic";
	
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String contato_ID = request.getParameter("id");
		String contato_Nome = request.getParameter("nome");
		String contato_Email = request.getParameter("email");
		String contato_Endereco = request.getParameter("endereco");
		String contato_DataNascimento = request.getParameter("dataNascimento");
		
		Calendar dataNascimento = null;
		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(contato_DataNascimento);
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		ContatoDao dao = new ContatoDao();
		
		Contato contato = new Contato();
		contato.setNome(contato_Nome);
		contato.setEmail(contato_Email);
		contato.setEndereco(contato_Endereco);
		contato.setDataNascimento(dataNascimento);
		
		if(contato_ID != null) {
			System.out.println("Alterando contato com a nova lógica...");
			
			contato.setId(Long.parseLong(contato_ID));
			dao.altera(contato);
			
			System.out.println("Contato "+contato.getNome()+" alterado!");
		}
		else {
			System.out.println("Adicionando contato com a nova lógica...");
			
			dao.adiciona(contato);
			
			System.out.println("Contato "+contato.getNome()+" adicionado!");
		}
		
		return JSP_PATH;
	}

}
