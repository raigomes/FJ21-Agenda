package br.com.caelum.jdbc.dao;

public class DaoException extends RuntimeException{

	private static final long serialVersionUID = 1L;	
	
	public DaoException(String origin, String method, Throwable arg0) {
		super(arg0);
		System.out.println("\nERRO proveniente da classe "+origin+" no método "+method+".");				
	}

	@Override
	public void printStackTrace() {		
		super.printStackTrace();
	}

}