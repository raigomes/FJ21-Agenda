<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Cabe�alho da Agenda</title>
	</head>
	<body>
		<c:url value='/img/logo.jpg' var="logo"/>		
		<img src= "${logo}" height="100px" width="100px"/>
		<h2>Agenda do Ra� Gomes</h2>
		<hr/>
	</body>
</html>