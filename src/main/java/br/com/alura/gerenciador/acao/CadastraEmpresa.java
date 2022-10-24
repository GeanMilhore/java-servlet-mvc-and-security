package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;
import br.com.alura.gerenciador.utils.DateUtil;

public class CadastraEmpresa {
	public String executa(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		String nomeEmpresa = request.getParameter("nome");
		String dataEmpresa = request.getParameter("data");

		System.out.println("acao cadastra empresa ");
		
		Date dataAbertura = DateUtil.parseDateFromString(dataEmpresa);
		
		Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(dataAbertura);
		
		Banco.adicionar(empresa);
		return "redirect:entrada?acao=ListaEmpresas";
	}
}
