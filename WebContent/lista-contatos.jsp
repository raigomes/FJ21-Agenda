<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
	<head>
		<title>Lista de Contatos</title>
	</head>
	<body>
		<c:import url="cabecalho.jsp"/>
		
		<jsp:useBean id="dao" class="br.com.caelum.jdbc.dao.ContatoDao" />
		
		<table border="1">	
			<thead>
				<tr>
					<td><strong>ID</strong></td>
					<td><strong>Nome</strong></td>
					<td><strong>Email</strong></td>
					<td><strong>Endereço</strong></td>
					<td><strong>Data de Nascimento</strong></td>
				</tr>
			</thead>
			<tbody> 
				<c:forEach var="contato" items="${dao.lista}" varStatus="id">
					<tr bgcolor="#${id.count % 2 == 0 ? 'aaee88' : 'ffffff'}">
						<td>
							${id.count}
						</td>
						<td>
							${contato.nome}
						</td>
						<td>
							<c:choose>
								<c:when test="${not empty contato.email}">
									<a href="mailto:${contato.email}">${contato.email}</a>
								</c:when>
								<c:otherwise>
									Email não informado
								</c:otherwise>
							</c:choose>							
						</td>
						<td>
							${contato.endereco}
						</td>
						<td>
							<fmt:formatDate value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy"/>							
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<c:import url="rodape.jsp"/>
	</body>
</html>