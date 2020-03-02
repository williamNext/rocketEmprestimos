package br.com.compasso.rocketEmprestimos.acao;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.compasso.rocketEmprestimos.dao.EmprestimoDAO;
import br.com.compasso.rocketEmprestimos.model.Emprestimo;
import br.com.compasso.rocketEmprestimos.util.JPAUtil;

public class DetalhaEmprestimo implements Acao{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Integer idEmprestimo = Integer.parseInt((String) request.getAttribute("idEmprestimo"));
		
		EntityManager em = new JPAUtil().getEntityManager();
		EmprestimoDAO emprestimoDAO = new EmprestimoDAO(em);
		
		Emprestimo emprestimo = emprestimoDAO.find(idEmprestimo);
		
		em.close();
		request.setAttribute("emprestimo", emprestimo);
		
		return "forward:detalhaEmprestimo.jsp";
	}

}
