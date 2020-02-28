package br.com.compasso.rocketEmprestimos.acao;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.compasso.rocketEmprestimos.dao.BaseDAO;
import br.com.compasso.rocketEmprestimos.model.Agencia;
import br.com.compasso.rocketEmprestimos.model.Cliente;
import br.com.compasso.rocketEmprestimos.model.Conta;
import br.com.compasso.rocketEmprestimos.model.Emprestimo;
import br.com.compasso.rocketEmprestimos.model.MetodoPagamento;
import br.com.compasso.rocketEmprestimos.model.Status;

public class CadastraEmprestimo implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		// dados cliente
		String nomecliente = request.getParameter("nomeCliente");
		String cpfCliente = request.getParameter("cpfCliente");
		// dados empréstimo
		BigDecimal valorEmprestimo = new BigDecimal(request.getParameter("valorEmprestimo"));
		int numeroParcela = Integer.valueOf(request.getParameter("numeroParcelas"));
		BigDecimal jurosMes = new BigDecimal(request.getParameter("jurosMes"));
		// dados conta
		String numeroConta = request.getParameter("numeroConta");
		// dados agencia
		String numeroAgencia = request.getParameter("numeroAgencia");
		String nomeAgencia = request.getParameter("nomeAgencia");

		String metodoPagamento = request.getParameter("metodoPagamento");

		MetodoPagamento pgmt = null;

		pgmt = checaFormaPagamento(metodoPagamento, pgmt);

		Agencia agencia = salvaAgencia(numeroAgencia, nomeAgencia);

		Cliente cliente = salvaCliente(nomecliente, cpfCliente);

		Conta conta = salvaConta(numeroConta, agencia, cliente);

		salvaEmprestimo(valorEmprestimo, numeroParcela, jurosMes, pgmt, conta);
		

		return "forward:cadastraEmprestimo.jsp";

	}


	private MetodoPagamento checaFormaPagamento(String metodoPagamento, MetodoPagamento pgmt) {
		switch (metodoPagamento) {
		case "CARTAO":
			pgmt = MetodoPagamento.CARTAO;
			break;
		case "BOLETO":
			pgmt = MetodoPagamento.BOLETO;

			break;
		case "DEBITO_EM_CONTA":
			pgmt = MetodoPagamento.DEBITO_EM_CONTA;

			break;
		default:
			throw new IllegalArgumentException();
		}
		return pgmt;
	}

}
