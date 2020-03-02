package br.com.compasso.rocketEmprestimos.acao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.compasso.rocketEmprestimos.dao.EmprestimoDAO;
import br.com.compasso.rocketEmprestimos.model.Emprestimo;
import br.com.compasso.rocketEmprestimos.util.JPAUtil;

/**
 * Servlet implementation class listaEmprestimos
 */
@WebServlet("/listaEmprestimos")
public class listaEmprestimos implements Acao{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EntityManager em = new JPAUtil().getEntityManager();
		EmprestimoDAO emprestimoDAO = new EmprestimoDAO(em);
		
		List<Emprestimo> lstEmprestimos = new ArrayList<>();
		
		lstEmprestimos = emprestimoDAO.findAll();
				
		request.setAttribute("emprestimos", lstEmprestimos);//quase certeza que nao e request
		
		em.close();
		
		return "forward:listaEmprestimos.jsp";
	}

	

}
