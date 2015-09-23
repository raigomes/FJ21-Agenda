package br.com.caelum.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.jdbc.ConnectionFactory;
import br.com.caelum.jdbc.modelo.Funcionario;

public class FuncionarioDao {
	private Connection connection;
	
	public FuncionarioDao() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void adiciona(Funcionario funcionario) {
		
		String query = "insert into funcionarios"
				+ "(nome, usuario, senha)" 
				+ "values (?, ?, ?)";
		
		try {
			//Preparando statement
			PreparedStatement stmt = connection.prepareStatement(query);
			
			//Seta valores de inserção
			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getUsuario());
			stmt.setString(3, funcionario.getSenha());
			
			//Executa e fecha statement
			stmt.execute();
			stmt.close();
			
			connection.close();
		}
		catch(SQLException e) {
			throw new DaoException("FuncionarioDao", "adiciona()", e);
		}
	}
	
	public List<Funcionario> getLista() {
		try {
			List<Funcionario> funcionarios = new ArrayList<>();
			//Prepara Statement com a query SELECT e executa-a, gurardando o resultado num ResultSet
			String query = "select * from funcionarios";
			PreparedStatement stmt = this.connection.prepareStatement(query);
			ResultSet rs  = stmt.executeQuery();
			
			while(rs.next()) {
				//Cria objeto Funcionario
				Funcionario fun = new Funcionario();
				fun.setId(rs.getLong("id"));
				fun.setNome(rs.getString("nome"));
				fun.setUsuario(rs.getString("usuario"));
				fun.setSenha(rs.getString("senha"));
				
				//Add objeto na lista
				funcionarios.add(fun);
			}
			
			rs.close();
			stmt.close();
			connection.close();
			
			return funcionarios;
		}
		catch (SQLException e) {
			throw new DaoException("FuncionarioDao", "getLista()", e);
		}
	}
	
	public Funcionario pesquisar(int id) {
		try {			
			String query = "select * from funcionarios where id = ?";
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				Funcionario fun = new Funcionario();
				
				fun.setId(rs.getLong("id"));
				fun.setNome(rs.getString("nome"));
				fun.setUsuario(rs.getString("usuario"));
				fun.setSenha(rs.getString("senha"));
				
				return fun;
			}
			else {
				return null;
			}			
		}
		catch (SQLException e) {
			throw new DaoException("FuncionarioDao", "pesquisar("+id+")", e);
		}
	}
	
	public boolean altera (Funcionario funcionario) {
		String query = "update funcionarios "
				+ "set nome = ?, usuario = ?, senha = ? "
				+ "where id = ?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setString(1, funcionario.getNome());
			stmt.setString(2, funcionario.getUsuario());
			stmt.setString(3, funcionario.getSenha());
			stmt.setLong(4, funcionario.getId());
			
			stmt.execute();
			stmt.close();
			
			return true;
		}
		catch(SQLException e) {
			throw new DaoException("FuncionarioDao", "altera(funcionario).\nFuncionario ="+funcionario, e);
		}
		
	}
	
	public boolean remove(long id) {
		String query = "delete from funcionarios where id = ?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setLong(1, id);			
			stmt.execute();
			stmt.close();
			return true;
		}
		catch(SQLException e) {
			throw new DaoException("FuncionarioDao", "remove("+id+")", e);
		}
	}
}
