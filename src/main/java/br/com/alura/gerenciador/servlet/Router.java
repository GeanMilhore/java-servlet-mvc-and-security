package br.com.alura.gerenciador.servlet;

public class Router {	
	public static String printarRotaCadastrarEmpresa() {
		return "<a href='http://localhost:8080/gerenciador/formNovaEmpresa.jsp'> Cadastrar Nova Empresa!</a></br>";
	}
	
	public static String printarRotaListarEmpresas() {
		return "<a href='http://localhost:8080/gerenciador/listaEmpresas'> Listar Empresas!</a>";
	}
}
