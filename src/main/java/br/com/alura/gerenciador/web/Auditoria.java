package br.com.alura.gerenciador.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.Usuario;

@WebFilter(urlPatterns = "/*")
public class Auditoria implements Filter {

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		 HttpServletRequest req = (HttpServletRequest) request;
		// HttpServletResponse resp = (HttpServletResponse) response;
		 String uri = req.getRequestURI();
		 String usuario = getUsuario(req);
		 
		 //Cookie c = new Cookies(req.getCookies()).buscaUsuarioLogado();
		 
		 /*if(c != null) {
			 c.setMaxAge(10 * 60);
			 resp.addCookie(c); 
		 }*/
		 
		 System.out.println("O usuario : " + usuario +" acessou a uri : " + uri);
		 
		 chain.doFilter(request, response);
	}

	private String getUsuario(HttpServletRequest req) {
		
		//Cookie c = new Cookies(req.getCookies()).buscaUsuarioLogado();
		
		 Usuario usu = (Usuario) req.getSession().getAttribute("usuarioLogado");
		 if(usu == null)return "<deslogado>";
		
		return usu.getEmail();
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
