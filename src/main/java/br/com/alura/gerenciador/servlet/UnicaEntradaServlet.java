package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.acao.Acao;

@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
        
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String paramAcao = request.getParameter("acao");
		
		HttpSession session = request.getSession();
		boolean usuarioLogado = session.getAttribute("usuarioLogado") != null;
		boolean acaoLivre = paramAcao.equals("Login") || paramAcao.equals("LoginForm") ;
		
		if(!usuarioLogado && !acaoLivre) {
			response.sendRedirect("entrada?acao=LoginForm");
			return;
		}
		
		String nomeDaClasse = "br.com.alura.gerenciador.acao."+ paramAcao; // Full Qualified Name
		
		String nome;
		try {
			Class classe = Class.forName(nomeDaClasse); 
			Acao acao = (Acao) classe.newInstance();
			nome = acao.executa(request, response);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | ServletException
				| IOException e) {
			throw new ServletException(e);
		}

		String[] tipoEndereco = nome.split(":");
		if(tipoEndereco[0].equals("forward")){

			RequestDispatcher rd = request.getRequestDispatcher("WEB-INF/view/"+tipoEndereco[1]);	
			rd.forward(request, response);
		} else {
			response.sendRedirect(tipoEndereco[1]);
		}
	}
}
