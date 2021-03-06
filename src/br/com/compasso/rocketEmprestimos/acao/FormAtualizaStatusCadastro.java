package br.com.compasso.rocketEmprestimos.acao;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.compasso.rocketEmprestimos.dao.EmprestimoDAO;
import br.com.compasso.rocketEmprestimos.model.Emprestimo;
import br.com.compasso.rocketEmprestimos.model.Status;

public class FormAtualizaStatusCadastro implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		EntityManager em = (EntityManager) request.getAttribute("entityManager");
		EmprestimoDAO emprestimoDAO = new EmprestimoDAO(em);
	    List<Emprestimo> emprestimos =  emprestimoDAO.findDiferentesDe(Status.APROVADO, Status.REPROVADO);
	    request.setAttribute("emprestimos", emprestimos);
		
		return "forward:aprovacaoEmprestimo.jsp";
	}
}
