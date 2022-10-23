<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="br.com.alura.gerenciador.servlet.Router"%>
<%@page import="java.util.ArrayList"%>
<%@page import="br.com.alura.gerenciador.servlet.Empresa"%>
<%@page import="java.util.List"%>
<%
	List<Empresa> empresasCadastradas = (List<Empresa>) request.getAttribute("empresas");
%>

<html>
	<body>
			<h2>Empresas Cadastradas</h2>
			<ul>
				<%
					for( Empresa empresa : empresasCadastradas ){
						out.println("<li>"+empresa+"</li>");
					}
				%>
			</ul>
			<%= Router.printarRotaCadastrarEmpresa() %>
	</body>
</html>