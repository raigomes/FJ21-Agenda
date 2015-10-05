<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>${param.nome} Adicionad@</title>
	</head>
	<body>
		<p>Contato ${param.nome} adicionado com sucesso</p><br/>
		<a href="mvc?logica=ListaContatosLogic">Voltar</a>
	</body>
</html>