package br.com.compasso.rocketEmprestimos.acao;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.compasso.rocketEmprestimos.dao.EmprestimoDAO;
import br.com.compasso.rocketEmprestimos.model.Emprestimo;

public class ListaEmprestimos implements Acao{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EntityManager em = (EntityManager) request.getAttribute("entityManager");
		EmprestimoDAO emprestimoDAO = new EmprestimoDAO(em);
		List<Emprestimo> listEmprestimos = emprestimoDAO.findAll();
		request.setAttribute("emprestimos", listEmprestimos);
		
		return "forward:listaEmprestimos.jsp";
	}
}
