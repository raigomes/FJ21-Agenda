<html>
	<head>
		<title>Primeira JSP</title>
	</head>
	<body>
		<%-- coment�rio em JSP aqui: nossa primeira p�gina em JSP --%>
		<%
			String mensagem = "Bem vindo ao sistema de agenda do FJ-21";
		%>
		<% out.println(mensagem); %>
		
		<br>
		
		<%
			String desenvolvido = "Desenvolvido por Ra� Gomes";
		%>
		<%= desenvolvido %>
		
		<br>
		
		<%
			System.out.println("Tudo foi executado!");
		%>		
	</body>
</html>