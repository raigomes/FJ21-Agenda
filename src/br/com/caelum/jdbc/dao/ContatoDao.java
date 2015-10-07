package br.com.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.modelo.Contato;

public class ContatoDao {
	private Connection connection;
	
	public ContatoDao(Connection connection) {
		this.connection = connection;
	}
	
	public void adiciona(Contato contato) {
		
		String query = "insert into contatos"
				+ "(nome, email, endereco, dataNascimento)" 
				+ "values (?, ?, ?, ?)";
		
		try {
			//Preparando statement
			PreparedStatement stmt = connection.prepareStatement(query);
			
			//Seta valores de inserção
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			
			if(contato.getDataNascimento() != null) 
				stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			else
				stmt.setDate(4, null);
			
			//Executa e fecha statement
			stmt.execute();
			stmt.close();
			
			connection.close();
		}
		catch(SQLException e) {
			throw new DaoException("ContatoDao", "adiciona()", e);
		}
	}
	
	public List<Contato> getLista() {
		try {
			List<Contato> contatos = new ArrayList<>();
			//Prepara Statement com a query SELECT e executa-a, gurardando o resultado num ResultSet
			String query = "select * from contatos";
			PreparedStatement stmt = this.connection.prepareStatement(query);
			ResultSet rs  = stmt.executeQuery();
			
			while(rs.next()) {
				//Cria objeto Contato
				Contato con = new Contato();
				con.setId(rs.getLong("id"));
				con.setNome(rs.getString("nome"));
				con.setEmail(rs.getString("email"));
				con.setEndereco(rs.getString("endereco"));
				
				//Insere dataNascimento no objeto
				Date date = rs.getDate("dataNascimento");
				
				if (date != null) {
					Calendar dataNascimento = Calendar.getInstance();
					SimpleDateFormat sf = new SimpleDateFormat("dd-MM-yyyy'T'HH:mm:ss");
					java.util.Date dataFormatada = sf.parse(sf.format(date));
					dataNascimento.setTime(dataFormatada);
					con.setDataNascimento(dataNascimento);
				}
				
				//Add objeto na lista
				contatos.add(con);
			}
			
			rs.close();
			stmt.close();
			connection.close();
			
			return contatos;
		}
		catch (SQLException e) {
			throw new DaoException("ContatoDao", "getLista()", e);
		}
		catch (ParseException e) {
			throw new DaoException("ContatoDao", "getLista()", e);
		}
	}
	
	public Contato pesquisar(int id) {
		try {			
			String query = "select * from contatos where id = ?";
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				Contato con = new Contato();
				
				con.setId(rs.getLong("id"));
				con.setNome(rs.getString("nome"));
				con.setEmail(rs.getString("email"));
				con.setEndereco(rs.getString("endereco"));
				
				Date date = rs.getDate("dataNascimento");
				
				if(date != null) {
					Calendar dataNascimento = Calendar.getInstance();
					dataNascimento.setTime(date);
					con.setDataNascimento(dataNascimento);
				}
				
				return con;
			}
			else {
				return null;
			}			
		}
		catch (SQLException e) {
			throw new DaoException("ContatoDao", "pesquisar("+id+")", e);
		}
	}
	
	public boolean altera (Contato contato) {
		String query = "update contatos "
				+ "set nome = ?, email = ?, endereco = ?, dataNascimento = ? "
				+ "where id = ?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			
			if(contato.getDataNascimento() != null) 
				stmt.setDate(4, new Date(contato.getDataNascimento().getTimeInMillis()));
			else
				stmt.setDate(4, null);
			
			stmt.setLong(5, contato.getId());
			
			stmt.execute();
			stmt.close();
			
			return true;
		}
		catch(SQLException e) {
			throw new DaoException("ContatoDao", "altera(contato).\nContato ="+contato, e);
		}
		
	}
	
	public boolean remove(long id) {
		String query = "delete from contatos where id = ?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setLong(1, id);			
			stmt.execute();
			stmt.close();
			return true;
		}
		catch(SQLException e) {
			throw new DaoException("ContatoDao", "remove("+id+")", e);
		}
	}
}
