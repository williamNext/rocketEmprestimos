package br.com.compasso.rocketEmprestimos.util;

import java.math.BigDecimal;

import javax.persistence.EntityManager;

import br.com.compasso.rocketEmprestimos.model.Agencia;
import br.com.compasso.rocketEmprestimos.model.Banco;
import br.com.compasso.rocketEmprestimos.model.Cliente;
import br.com.compasso.rocketEmprestimos.model.Conta;
import br.com.compasso.rocketEmprestimos.model.Emprestimo;
import br.com.compasso.rocketEmprestimos.model.MetodoPagamento;
import br.com.compasso.rocketEmprestimos.model.Status;

public class PopulaBanco {
	
	public static void main(String[] args) {
		
		EntityManager manager = new JPAUtil().getEntityManager();

		manager.getTransaction().begin();
		
		Banco banco1 = new Banco();
		Banco banco2 = new Banco();
		Banco banco3 = new Banco();
		Banco banco4 = new Banco();
		Banco banco5 = new Banco();
		
		banco1.setNome("Sicred");
		banco2.setNome("Banrisul");
		banco3.setNome("Ita�");
		banco4.setNome("Inter");
		banco5.setNome("Santander");
		
		Agencia agencia1 = new Agencia();
		Agencia agencia2 = new Agencia();
		Agencia agencia3 = new Agencia();
		Agencia agencia4 = new Agencia();
		Agencia agencia5 = new Agencia();
		
		agencia1.setBanco(banco1);
		agencia1.setNumero(2026);
		
		agencia2.setBanco(banco2);
		agencia2.setNumero(1053);
		
		agencia3.setBanco(banco3);
		agencia3.setNumero(1315);
		
		agencia4.setBanco(banco4);
		agencia4.setNumero(4645);
		
		agencia5.setBanco(banco5);
		agencia5.setNumero(5862);
		
		Cliente cliente1 = new Cliente();
		Cliente cliente2 = new Cliente();
		Cliente cliente3 = new Cliente();
		Cliente cliente4 = new Cliente();
		Cliente cliente5 = new Cliente();
		
		cliente1.setNome("Kaiser");
		cliente1.setCpf("66426745268");
		cliente2.setNome("Dovakin");
		cliente2.setCpf("42628548264");
		cliente3.setNome("Ruffus");
		cliente3.setCpf("64588426517");
		cliente4.setNome("Arthur");
		cliente4.setCpf("64124558848");
		cliente5.setNome("Arthas");
		cliente5.setCpf("26539287916");
		
		Conta conta1 = new Conta();
		Conta conta2 = new Conta();
		Conta conta3 = new Conta();
		Conta conta4 = new Conta();
		Conta conta5 = new Conta();
		
		conta1.setAgencia(agencia1);
		conta1.setCliente(cliente1);
		conta2.setAgencia(agencia2);
		conta2.setCliente(cliente2);
		conta3.setAgencia(agencia3);
		conta3.setCliente(cliente3);
		conta4.setAgencia(agencia4);
		conta4.setCliente(cliente4);
		conta5.setAgencia(agencia5);
		conta5.setCliente(cliente5);
		
		
		Emprestimo emprestimo1 = new Emprestimo();
		Emprestimo emprestimo2 = new Emprestimo();
		Emprestimo emprestimo3 = new Emprestimo();
		Emprestimo emprestimo4 = new Emprestimo();
		Emprestimo emprestimo5 = new Emprestimo();
		
		emprestimo1.setConta(conta1);	;
		emprestimo1.setStatus(Status.APROVADO);
		emprestimo1.setValor(new BigDecimal(5000));
		emprestimo1.setPagamento(MetodoPagamento.CARTAO);
		emprestimo1.setJurosAoMes(new BigDecimal(1.2/100));
		
		emprestimo2.setConta(conta1);	;
		emprestimo2.setStatus(Status.EM_ANALISE);
		emprestimo2.setValor(new BigDecimal(100000));
		emprestimo2.setPagamento(MetodoPagamento.BOLETO);
		emprestimo2.setJurosAoMes(new BigDecimal(0.5/100));
		
		emprestimo3.setConta(conta1);	;
		emprestimo3.setStatus(Status.APROVADO);
		emprestimo3.setValor(new BigDecimal(27500));
		emprestimo3.setPagamento(MetodoPagamento.DEBITO_EM_CONTA);
		emprestimo3.setJurosAoMes(new BigDecimal(1.0/100));
		
		emprestimo4.setConta(conta1);	;
		emprestimo4.setStatus(Status.SOLICITACAO_ENVIADA);
		emprestimo4.setValor(new BigDecimal(650000));
		emprestimo4.setPagamento(MetodoPagamento.DEBITO_EM_CONTA);
		emprestimo4.setJurosAoMes(new BigDecimal(0.55/100));
		
		emprestimo5.setConta(conta1);	;
		emprestimo5.setStatus(Status.REPROVADO);
		emprestimo5.setValor(new BigDecimal(90000));
		emprestimo5.setPagamento(MetodoPagamento.BOLETO);
		emprestimo5.setJurosAoMes(new BigDecimal(2.0/100));
		
		
		
		manager.getTransaction().commit();
		manager.close();
		
	}

}