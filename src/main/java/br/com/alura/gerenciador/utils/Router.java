package br.com.alura.gerenciador.utils;

public class Router {	
	public static String printarRotaCadastrarEmpresa() {
		return "<a href='http://localhost:8080/gerenciador/formNovaEmpresa.jsp'> Cadastrar Nova Empresa!</a></br>";
	}
	
	public static String printarRotaListarEmpresas() {
		return "<a href='http://localhost:8080/gerenciador/entrada?acao=ListaEmpresas'> Listar Empresas!</a>";
	}
	
	public static String printarRotaHome() {
		return "<a href='http://localhost:8080/gerenciador'> Home </a>";
	}
}
