<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="dt" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Formulário de Cadastro</title>
		<link rel="stylesheet" href="css/jquery-ui.css" />
		<script src="js/jquery.js" ></script>
		<script src="js/jquery-ui.js" ></script>
	</head>
	<body>
		<c:import url="cabecalho.jsp"/>
	
		<h1>Adiciona Contatos</h1>
		<hr>
		<form action="adicionaContato" method="post">
			Nome: <input type="text" name="nome" /><br />
			E-mail: <input type="email" name="email" /><br />
			Endereço: <input type="text" name="endereco" /><br />
			Data de Nascimento: <dt:campoData id="dataNascimento" /><br />
			
			<input type="submit" value="Gravar"/>
		</form>
		
		<c:import url="rodape.jsp"/>
	</body>
</html>