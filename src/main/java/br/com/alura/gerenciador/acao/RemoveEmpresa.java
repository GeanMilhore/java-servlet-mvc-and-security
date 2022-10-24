package br.com.alura.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;

public class RemoveEmpresa implements Acao {
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idEmpresaRemoved = request.getParameter("idRemove");
		System.out.println("acao remove empresa " + idEmpresaRemoved);
		Banco.removerEmpresa(Integer.valueOf(idEmpresaRemoved));
		
		return "redirect:entrada?acao=ListaEmpresas";
	}
}
