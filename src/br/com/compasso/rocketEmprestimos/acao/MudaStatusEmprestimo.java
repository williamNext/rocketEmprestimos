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


public class MudaStatusEmprestimo implements Acao {// extends HttpServelt

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		EntityManager em = new JPAUtil().getEntityManager();
		EmprestimoDAO emprestimoDAO = new EmprestimoDAO(em);

		Integer idEmprestimo = Integer.parseInt(request.getParameter("idEmprestimo"));
		String statusDoEmprestimo = request.getParameter("novoStatus");
		Emprestimo emprestimo = emprestimoDAO.find(idEmprestimo);

		Status status = Status.valueOf(statusDoEmprestimo);

		emprestimo.setStatus(status);

		emprestimoDAO.saveOrUpdate(emprestimo);

		em.close();

		return "forward:aprovaEmprestimo.jsp";

	}

}

/*
 * SOLICITACAO_ENVIADA, EM_ANALISE, APROVADO, REPROVADO
 */