package br.com.compasso.rocketEmprestimos.acao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.compasso.rocketEmprestimos.dao.EmprestimoDAO;
import br.com.compasso.rocketEmprestimos.model.Emprestimo;
import br.com.compasso.rocketEmprestimos.model.Status;

public class ListaStatusNaoFinais implements Acao {
	
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		
		EntityManager em = (EntityManager) request.getAttribute("entityManager");
		EmprestimoDAO emprestimoDAO = new EmprestimoDAO(em);
		List<Emprestimo> lstEmprestimos = emprestimoDAO.findDiferentesDe(Status.APROVADO, Status.REPROVADO);
		request.setAttribute("listEmprestimos", lstEmprestimos);
		
		return "forward:ListaStatusNaoFinais.jsp";//nome provisorio
	}
	
	
	
	
	
	
	

}
