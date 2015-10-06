package br.com.caelum.agenda.filtro;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/*
 * - Implementa l�gica para contar o tempo de execu��o de uma requisi��o;
 * - Todo o c�digo declarando dentro de doFilter() que esteja antes do m�todo chain.doFilter() 
 * � executado antes da Servlet;
 * - De maneira an�loga, o c�digo decarado ap�s chain.doFilter() � executado ap�s a Servlet.
 * 
 */

@WebFilter("/*")
public class FiltroTempoExecucao implements Filter {

	@Override
	public void init(FilterConfig arg0) 
			throws ServletException {
		
	}
	
	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest request, 
			ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		long tempoInicial = System.currentTimeMillis();
		
		chain.doFilter(request, response);
		
		long tempoFinal = System.currentTimeMillis();
		String uri = ((HttpServletRequest) request).getRequestURI();
		String parametros = ((HttpServletRequest)request).getParameter("logica");
		
		System.out.println("O tempo de execu��o de " + uri +
				"?logica=" + parametros + " � " +  
				(tempoFinal - tempoInicial) + "ms.");
		
	}

}
