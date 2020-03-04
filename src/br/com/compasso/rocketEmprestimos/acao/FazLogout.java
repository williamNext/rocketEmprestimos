package br.com.compasso.rocketEmprestimos.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FazLogout implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.getSession().setAttribute("usuarioLogado", null);
		
		return "redirect:emprestimos?acao=FormLogin";
	}

}
