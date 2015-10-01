<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="dt" %>

<html>
	<head>
		<title>Lista de Contatos</title>				
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/jquery-ui.js"></script>		
		<script type="text/javascript" src="js/main.js"></script>
	</head>
	<body>
		<c:import url="cabecalho.jsp"/>
		
		<form action="">
			<strong>Nome: </strong>
			<input id="name" type="text" value="${contato.nome}" disabled />
			<a href="javascript:void(0)" onclick="javascript:habilitaCampo('name')">Editar</a><br/>
			
			<strong>Email: </strong>
			<input id="email" type="text" value="${contato.email}" disabled />
			<a href="javascript:void(0)" onclick="javascript:habilitaCampo('email')">Editar</a><br/>
			
			<strong>Endereço: </strong>
			<input id="address" type="text" value="${contato.endereco}" disabled />
			<a href="javascript:void(0)" onclick="javascript:habilitaCampo('address')">Editar</a><br/>
			
			<c:set var="dataNascimento">
				<fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy"/>
			</c:set>
			<strong>Data de Nascimento: </strong>			
			<dt:campoData id="birthday" value="${dataNascimento}" disabled="true" />
			<a href="javascript:void(0)" onclick="javascript:habilitaCampoData('birthday')">Editar</a><br/>			
			
			<input type="submit" value="Altera Contato" />
		</form>
		<c:import url="rodape.jsp"/>
	</body>
</html>