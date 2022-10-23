package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class VisualizarEmpresa {
	public void executa(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String idEmpresa = request.getParameter("id");

		Optional<Empresa> empresaEditar = Banco.getEmpresaById(Integer.valueOf(idEmpresa));
		if(empresaEditar.isPresent()) request.setAttribute("empresa", empresaEditar.get());

		RequestDispatcher rd = request.getRequestDispatcher("/formEditaEmpresa.jsp");
		rd.forward(request, response);
	}
}
