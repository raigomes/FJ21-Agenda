<html>
	<head>
		<title>Primeira JSP</title>
	</head>
	<body>
		<%-- comentário em JSP aqui: nossa primeira página em JSP --%>
		<%
			String mensagem = "Bem vindo ao sistema de agenda do FJ-21";
		%>
		<% out.println(mensagem); %>
		
		<br>
		
		<%
			String desenvolvido = "Desenvolvido por Raí Gomes";
		%>
		<%= desenvolvido %>
		
		<br>
		
		<%
			System.out.println("Tudo foi executado!");
		%>		
	</body>
</html>