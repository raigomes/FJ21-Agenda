<%@page import="java.sql.Connection"%>
<%@page import="java.util.Date"%>
<%@ page import="java.util.*,
		java.text.*, 
		br.com.caelum.jdbc.dao.*, 
		br.com.caelum.jdbc.modelo.*" %>

<html>
	<body>
		<table>
			<thead>			
				<tr>
					<td>Nome</td>
					<td>Email</td>
					<td>Endereço</td>
					<td>Data de Nascimento</td>
				</tr>
			</thead>
			<tbody>
				<%
					Connection connection = (Connection) request.getAttribute("conexao"); 
					ContatoDao dao = new ContatoDao(connection);
					List<Contato> contatos = dao.getLista();
					
					for (Contato contato: contatos) {
				%>
				<tr>
					<td><%=contato.getNome() %></td>
					<td><%=contato.getEmail() %></td>
					<td><%=contato.getEndereco() %></td>
					<% SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy"); %>
					<% String dataNascimento = sd.format(contato.getDataNascimento().getTime()); %>
					<td><%=dataNascimento %></td>
				</tr>
				<%
					}
				%> 
			</tbody>
		</table>
	</body>
</html>