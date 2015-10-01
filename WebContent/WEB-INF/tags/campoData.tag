<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ attribute name="id" required="true" %>
<%@ attribute name="value" required="false" %>
<%@ attribute name="disabled" required="false" %>

<c:set var="fieldValue">
	<c:choose>
		<c:when test="${not empty value}">
			${value}			
		</c:when>
		<c:otherwise>
			 / / 
		</c:otherwise>
	</c:choose>
</c:set>

<c:choose>
	<c:when test="${not empty disabled and disabled == 'true'}">
		<input id="${id}" name="${id}" value="${fieldValue}" disabled />
	</c:when>
	<c:otherwise>
		<input id="${id}" name="${id}" value="${fieldValue}" />
		<script>
			datepicker("${id}");
		</script>
	</c:otherwise>
</c:choose>

