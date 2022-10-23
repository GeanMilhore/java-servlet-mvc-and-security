<%@page import="br.com.alura.gerenciador.servlet.DateUtil"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/novaEmpresa" var="linkServletNovaEmpresa"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="${linkServletNovaEmpresa}" method="POST">
		<input type="hidden" name="id" value="${empresa.id}" />
		Nome: <input type="text" name="nome" value="${empresa.nome} "/>
		Data Abertura: <input type="date" name="data" value="${ empresa.dataAberturaFormated }" />
		<input type="submit" value="Enviar"/>
	</form>	
	
</body>
</html>