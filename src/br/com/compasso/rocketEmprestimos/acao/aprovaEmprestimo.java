package br.com.compasso.rocketEmprestimos.acao;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.compasso.rocketEmprestimos.dao.EmprestimoDAO;
import br.com.compasso.rocketEmprestimos.model.Emprestimo;
import br.com.compasso.rocketEmprestimos.model.Status;
import br.com.compasso.rocketEmprestimos.util.JPAUtil;

/**
 * Servlet implementation class aprovaEmprestimo
 */

public class aprovaEmprestimo implements Acao{//extends HttpServelt

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EntityManager em = new JPAUtil().getEntityManager();
		EmprestimoDAO emprestimoDAO = new EmprestimoDAO(em);
		
		Integer idEmprestimo = Integer.parseInt(request.getParameter("idEmprestimo"));
		Emprestimo emprestimo = emprestimoDAO.find(idEmprestimo);
		
		emprestimo.setStatus(Status.APROVADO);
		
		emprestimoDAO.saveOrUpdate(emprestimo);
		
		em.close();

		return "forward:aprovaEmprestimo.jsp"; 
		
	}


}