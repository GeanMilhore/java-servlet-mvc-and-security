package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;

public class RemoveEmpresa {
	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idEmpresaRemoved = request.getParameter("idRemove");
		System.out.println("acao remove empresa " + idEmpresaRemoved);
		Banco.removerEmpresa(Integer.valueOf(idEmpresaRemoved));
		response.sendRedirect("entrada?acao=ListaEmpresas");
	}
}
