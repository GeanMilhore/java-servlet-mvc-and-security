<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/entrada" var="linkEntradaServlet"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<c:import url="logout-parcial.jsp" />
	<form action="${linkEntradaServlet}" method="POST">
		<input type="hidden" name="id" value="${empresa.id}" />
		Nome: <input type="text" name="nome" value="${empresa.nome} "/>
		Data Abertura: <input type="date" name="data" value="${ empresa.dataAberturaFormated }" />
		<input type="hidden" name="acao" value="AlteraEmpresa" />
		<input type="submit" value="Enviar"/>
	</form>	
	<c:import url="home-parcial.jsp" />
</body>
</html>