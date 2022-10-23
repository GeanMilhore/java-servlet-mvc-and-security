package br.com.alura.gerenciador.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/novaEmpresa")
public class NovaEmpresaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		System.out.println("Cadastrando nova empresa");
		
		String idEmpresa = request.getParameter("id");
		String nomeEmpresa = request.getParameter("nome");
		String dataEmpresa = request.getParameter("data");
		
		Date dataAbertura = DateUtil.parseDateFromString(dataEmpresa);
		
		Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAbertura);
		
		Optional<Empresa> optEmpresa = Optional.empty();
		if(idEmpresa != null && !idEmpresa.isEmpty()) optEmpresa = Banco.getEmpresaById(Integer.valueOf(idEmpresa));
		if(optEmpresa.isPresent()) Banco.editarEmpresa(Integer.valueOf(idEmpresa), empresa);
		else Banco.adicionar(empresa);
		
		response.sendRedirect("listaEmpresas");
		// chamar outro servlet
//		RequestDispatcher rd = request.getRequestDispatcher("/listaEmpresas");
//		request.setAttribute("empresa", empresa.getNome());
//		rd.forward(request, response);
	}

}
