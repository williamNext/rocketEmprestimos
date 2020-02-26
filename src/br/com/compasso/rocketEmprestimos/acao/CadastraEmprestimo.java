package br.com.compasso.rocketEmprestimos.acao;

import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CadastraEmprestimo implements Acao{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) {
		//dados cliente
				String nomecliente = request.getParameter("nomeCliente");
				String cpfCliente = request.getParameter("cpfCliente");
				//dados empréstimo
				BigDecimal valorEmprestimo = new BigDecimal(request.getParameter("valorEmprestimo"));
				int numeroParcela = Integer.valueOf(request.getParameter("numeroParcelas"));
				BigDecimal jurosMes = new BigDecimal(request.getParameter("jurosMes"));
				
				String numeroConta = request.getParameter("numeroConta");
				String numeroAgencia  = request.getParameter("numeroAgencia");
				String nomeAgencia = request.getParameter("nomeAgencia");
				
				String  metodoPagamento = request.getParameter("metodoPagamento");
			
				MetodoPagamento  pgmt;
				switch (metodoPagamento) {
				case "CARTAO":
					pgmt= MetodoPagamento.CARTAO;	
					break;
				case "BOLETO":
					pgmt= MetodoPagamento.BOLETO;	
				
					break;
				default:
					break;
				}
				
				Agencia agencia=new Agencia(numeroAgencia, nomeAgencia);
				
				GenericDao.salva(agencia);
				
		        Cliente cliente=new Cliente(nomecliente, cpfCliente);
				
				GenericDao.salva(cliente);
				
		        Conta conta  =new Conta(numeroConta, cliente, agencia);
				
				GenericDao.salva(conta);
				
		        Emprestimo emprestimo=new Emprestimo(conta, StatusConta.PENDENTE, valorEmprestimo, numeroParcela,jurosMes, pgmt );
				
				GenericDao.salva(emprestimo);

				return "forward:cadastraEmprestimo.jsp";
					
	}

	
	
}
