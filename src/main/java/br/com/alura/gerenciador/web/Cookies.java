package br.com.alura.gerenciador.web;

import javax.servlet.http.Cookie;

public class Cookies {
	
	
	private final Cookie[] cookies;


	public Cookies(Cookie[] cookies){
		this.cookies = cookies; // pega o cookie ao instanciar essa classe
	}							// Entao a variavel cookie esta null ou com o cookie.
	
	
	public Cookie buscaUsuarioLogado(){
		
		if(cookies == null) return null;
		
		for(Cookie cookie : cookies) {
			if(cookie.getName().equals("usuario.logado")){
				return cookie;
			}
		}
		return null;
	}
	
}
// classe fica inutilizavel apartir da aula com session.
