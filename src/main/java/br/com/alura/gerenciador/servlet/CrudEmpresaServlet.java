package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

@WebServlet("/crudEmpresa")
public class CrudEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idEmpresa = request.getParameter("id");
		String idEmpresaRemoved = request.getParameter("idRemove");
		
		RequestDispatcher rd = request.getRequestDispatcher("/formNovaEmpresa.jsp");
		
		if(idEmpresa != null && !idEmpresa.isEmpty()) {
			Optional<Empresa> empresaEditar = Banco.getEmpresaById(Integer.valueOf(idEmpresa));
			if(empresaEditar.isPresent()) request.setAttribute("empresa", empresaEditar.get());
			rd.forward(request, response);
		}
		
		if(idEmpresaRemoved != null && !idEmpresaRemoved.isEmpty() ) {
			Banco.removerEmpresa(Integer.valueOf(idEmpresaRemoved));
			response.sendRedirect("/gerenciador/listaEmpresas");
		}
	}

}
