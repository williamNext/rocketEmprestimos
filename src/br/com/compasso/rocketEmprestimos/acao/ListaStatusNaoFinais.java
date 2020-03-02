package br.com.compasso.rocketEmprestimos.acao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.compasso.rocketEmprestimos.dao.EmprestimoDAO;
import br.com.compasso.rocketEmprestimos.model.Emprestimo;
import br.com.compasso.rocketEmprestimos.model.Status;
import br.com.compasso.rocketEmprestimos.util.JPAUtil;

/**
 * Servlet implementation class ListaStatusNaoFinais
 */
@WebServlet("/ListaStatusNaoFinais")
public class ListaStatusNaoFinais implements Acao {
	
	
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		
		EntityManager em = new JPAUtil().getEntityManager();
		EmprestimoDAO emprestimoDAO = new EmprestimoDAO(em);
		
		List<Emprestimo> lstEmprestimos = emprestimoDAO.findDiferentesDe(Status.APROVADO, Status.REPROVADO);
		
		request.setAttribute("lstEmprestimosNaoFinais", lstEmprestimos);//revisar esta linha
		
		em.close();
		
		return "forward:ListaStatusNaoFinais.jsp";//nome provisorio
	}
	
	
	
	
	
	
	

}
