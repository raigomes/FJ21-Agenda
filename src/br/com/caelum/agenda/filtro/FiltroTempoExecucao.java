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
 * - Implementa lógica para contar o tempo de execução de uma requisição;
 * - Todo o código declarando dentro de doFilter() que esteja antes do método chain.doFilter() 
 * é executado antes da Servlet;
 * - De maneira análoga, o código decarado após chain.doFilter() é executado após a Servlet.
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
		
		System.out.println("O tempo de execução de " + uri +
				"?logica=" + parametros + " é " +  
				(tempoFinal - tempoInicial) + "ms.");
		
	}

}
