package br.com.compasso.rocketEmprestimos.acao;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.compasso.rocketEmprestimos.dao.EmprestimoDAO;
import br.com.compasso.rocketEmprestimos.model.Emprestimo;

public class DetalhaEmprestimo implements Acao{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		EntityManager em = (EntityManager) request.getAttribute("entityManager");		
		Integer idEmprestimo = Integer.parseInt(request.getParameter("id"));
		
	
		
		EmprestimoDAO emprestimoDAO = new EmprestimoDAO(em);
		Emprestimo emprestimo = emprestimoDAO.find(idEmprestimo);
		request.setAttribute("emprestimo", emprestimo);
		
		return "forward:detalhesEmprestimo.jsp";
	}
}
