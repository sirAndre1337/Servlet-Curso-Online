package br.com.alura.gerenciador.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.Usuario;
import br.com.alura.gerenciador.dao.UsuarioDAO;

@WebServlet(urlPatterns="/login")
public class Login implements Tarefa{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Override
	public String executa(HttpServletRequest req, HttpServletResponse resp) {
	
		
		String email = req.getParameter("email");
		String senha = req.getParameter("senha");
		
		
		Usuario usu = new UsuarioDAO().buscaPorEmailESenha(email, senha);
		
		if(usu == null) {
			return "WEB-INF/webapp/login.jsp";
		} else {
			HttpSession session = req.getSession();
			session.setAttribute("usuarioLogado", usu);
		//	Cookie biscoito = new Cookie("usuario.logado", email);
		//	biscoito.setMaxAge(60*10);
		//	resp.addCookie(biscoito);
			return "WEB-INF/webapp/login.jsp";
	
	
		}
	}
}