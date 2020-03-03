package br.com.compasso.rocketEmprestimos.acao;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.compasso.rocketEmprestimos.dao.EmprestimoDAO;
import br.com.compasso.rocketEmprestimos.model.Emprestimo;
import br.com.compasso.rocketEmprestimos.model.Status;

public class MudaStatusEmprestimo implements Acao {// extends HttpServelt

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		EntityManager em = (EntityManager) request.getAttribute("entityManager");
		EmprestimoDAO emprestimoDAO = new EmprestimoDAO(em);

		Integer idEmprestimo = Integer.parseInt(request.getParameter("id"));
		
		System.out.println(request.getParameter("id"));
		
		String statusDoEmprestimo = request.getParameter("status");
		Emprestimo emprestimo = emprestimoDAO.find(idEmprestimo);
		Status status = Status.valueOf(statusDoEmprestimo);
		emprestimo.setStatus(status);

		emprestimoDAO.saveOrUpdate(emprestimo);

		return "redirect:emprestimos?acao=FormAtualizaStatusCadastro";
	}
}
