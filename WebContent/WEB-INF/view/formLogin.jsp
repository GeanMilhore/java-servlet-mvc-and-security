<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/entrada" var="linkServletNovaEmpresa"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="${linkServletNovaEmpresa}" method="POST">
		<input type="hidden" name="id" />
		Login: <input type="text" name="login" />
		Senha: <input type="password" name="senha" />
		<input type="hidden" name="acao" value="Login" />
		<input type="submit" value="Entrar"/>
	</form>
</body>
</html>