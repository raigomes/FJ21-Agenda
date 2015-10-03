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
		
		<form action="mvc?logica=AlteraContatoLogic" method="post">
			<input id="id" name="id" type="hidden" value="${contato.id}" readonly />
		
			<strong>Nome: </strong>
			<input id="nome" name="nome" type="text" value="${contato.nome}" readonly />
			<a id="lbl_nome" href="javascript:void(0)" onclick="javascript:habilitaCampo('nome')">Editar</a><br/>
			
			<strong>Email: </strong>
			<input id="email" name="email" type="text" value="${contato.email}" readonly />
			<a id="lbl_email" href="javascript:void(0)" onclick="javascript:habilitaCampo('email')">Editar</a><br/>
			
			<strong>Endereço: </strong>
			<input id="endereco" name="endereco" type="text" value="${contato.endereco}" readonly />
			<a id="lbl_endereco" href="javascript:void(0)" onclick="javascript:habilitaCampo('endereco')">Editar</a><br/>
			
			<c:set var="dataNascimento">
				<fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy"/>
			</c:set>
			<strong>Data de Nascimento: </strong>			
			<dt:campoData id="dataNascimento" value="${dataNascimento}" readonly="true" />
			<a id="lbl_dataNascimento" href="javascript:void(0)" onclick="javascript:habilitaCampoData('dataNascimento')">Editar</a><br/>			
			
			<input type="submit" value="Altera Contato" />
		</form>
		<c:import url="rodape.jsp"/>
	</body>
</html>