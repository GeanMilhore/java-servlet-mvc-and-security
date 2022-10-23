<%@page import="br.com.alura.gerenciador.servlet.Router"%>
<%
	//scriptlet
	String nomeEmpresa = (String) request.getAttribute("empresa");
	System.out.println(nomeEmpresa);
%>

<html>
<body>
	Empresa <%= nomeEmpresa %> cadastrada com sucesso! </br>
	<%= Router.printarRotaCadastrarEmpresa() %>
	<%= Router.printarRotaListarEmpresas() %>
</body>
</html>