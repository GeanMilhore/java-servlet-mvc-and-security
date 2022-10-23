<%@page import="br.com.alura.gerenciador.utils.Router"%>
<%@page import="br.com.alura.gerenciador.modelo.Empresa"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Java Standard Taglib</title>
<script type="text/javascript">
	// o empresa.nome na verdade ira chamar o método getNome de Empresa
</script>
</head>
	<body>
			<c:if test="${not empty empresa}" >
				Empresa ${ empresa } cadastrada com sucesso! </br>
			</c:if>
			
			<h2>Empresas Cadastradas</h2>
			
			<ul>
				<c:forEach items="${empresas}" var="empresa">	
					<li>${empresa.nome} - <fmt:formatDate pattern="dd/MM/yyyy" value="${empresa.dataAbertura }" />
						| <a href="/gerenciador/crudEmpresa?id=${empresa.id}">editar</a>
						| <a href="/gerenciador/crudEmpresa?idRemove=${empresa.id}">remover</a>
					</li>
				</c:forEach>
			</ul>
			<%= Router.printarRotaCadastrarEmpresa() %>
	</body>
</html>