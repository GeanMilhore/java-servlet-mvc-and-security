package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class ListaEmpresas {

	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("acao lista empresas");
		List<Empresa> empresas = Banco.getEmpresas();
		request.setAttribute("empresas", empresas);
		
		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas.jsp");	
		rd.forward(request, response);
	}
}
