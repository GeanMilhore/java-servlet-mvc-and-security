<%@page import="br.com.alura.gerenciador.servlet.Router"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<body>

	<%= Router.printarRotaCadastrarEmpresa() %>
	<%= Router.printarRotaListarEmpresas() %>
</body>
</html>