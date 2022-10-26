package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Usuario;

public class Login implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		
		System.out.println("Logando "+ login);
		
		Optional<Usuario> optUsuario = Banco.existeUsuario(senha,login);
		
		if (optUsuario.isPresent()) {
			HttpSession sessao = request.getSession(); // pega o id do cookie do navegador e dependendo do navegador retorna uma sessão
			sessao.setAttribute("usuarioLogado", optUsuario.get());
			return "redirect:entrada?acao=ListaEmpresas";
		}
		return "redirect:entrada?acao=LoginForm";
	}

}
