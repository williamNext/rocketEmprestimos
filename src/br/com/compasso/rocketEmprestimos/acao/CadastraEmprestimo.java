package br.com.compasso.rocketEmprestimos.acao;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.compasso.rocketEmprestimos.dao.ClienteDAO;
import br.com.compasso.rocketEmprestimos.dao.EmprestimoDAO;
import br.com.compasso.rocketEmprestimos.model.Cliente;
import br.com.compasso.rocketEmprestimos.model.Emprestimo;
import br.com.compasso.rocketEmprestimos.model.MetodoPagamento;
import br.com.compasso.rocketEmprestimos.model.Status;
import br.com.compasso.rocketEmprestimos.util.JPAUtil;

public class CadastraEmprestimo implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {

		String nomecliente = request.getParameter("nomeCliente");
		
		BigDecimal valorEmprestimo = new BigDecimal(request.getParameter("valorEmprestimo"));
		int numeroParcela = Integer.valueOf(request.getParameter("numeroParcelas"));
		BigDecimal jurosMes = new BigDecimal(request.getParameter("jurosMes"));
	
		String metodoPagamento = request.getParameter("metodoPagamento");

		MetodoPagamento pgmt = checaFormaPagamento(metodoPagamento);

		EntityManager em = new JPAUtil().getEntityManager();
	
		Cliente cliente  = new ClienteDAO(em).findByNome(nomecliente);
		
		Emprestimo emprestimo = preparaEmprestimo(numeroParcela, jurosMes, pgmt, cliente);
		
		EmprestimoDAO emprestimoDAO = new EmprestimoDAO(em);
		emprestimoDAO.saveOrUpdate(emprestimo);
		
		em.close();
		
		return "redirect:emprestimos?acao=FormCadastraEmprestimo";

	}


	private Emprestimo preparaEmprestimo(int numeroParcela, BigDecimal jurosMes, MetodoPagamento pgmt,
			Cliente cliente) {
		Emprestimo emprestimo = new Emprestimo();
		emprestimo.setConta(cliente.getConta());
		emprestimo.setJurosAoMes(jurosMes);
		emprestimo.setPagamento(pgmt);
		emprestimo.setParcelas(numeroParcela);
		emprestimo.setStatus(Status.SOLICITACAO_ENVIADA);
		return emprestimo;
	}


	public MetodoPagamento checaFormaPagamento(String metodoPagamento) {
		
		MetodoPagamento valueOf = MetodoPagamento.valueOf(metodoPagamento);

//		}
		return valueOf;
	}

}
