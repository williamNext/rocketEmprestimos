package br.com.compasso.rocketEmprestimos.acao;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.compasso.rocketEmprestimos.dao.UsuarioDAO;
import br.com.compasso.rocketEmprestimos.model.Usuario;

public class ValidaLogin implements Acao{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		
		String login = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		EntityManager em = (EntityManager) request.getAttribute("entityManager");
		
		UsuarioDAO usuarioDAO = new UsuarioDAO(em);
		Usuario user = usuarioDAO.findByLoginAndSenha(login, senha);
		
		if (user != null) {
			request.getSession().setAttribute("usuarioLogado", user);
			return "redirect:emprestimos?acao=FormCadastraEmprestimo";
		}
		
		return "redirect:emprestimos?acao=FormLogin";
	}
}
