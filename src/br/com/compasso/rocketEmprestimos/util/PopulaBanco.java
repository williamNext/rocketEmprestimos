package br.com.compasso.rocketEmprestimos.util;

import javax.persistence.EntityManager;

import br.com.compasso.rocketEmprestimos.model.Agencia;
import br.com.compasso.rocketEmprestimos.model.Banco;
import br.com.compasso.rocketEmprestimos.model.Conta;

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
		banco3.setNome("Itaú");
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
		
		Conta conta1 = new Conta();
		Conta conta2 = new Conta();
		Conta conta3 = new Conta();
		Conta conta4 = new Conta();
		Conta conta5 = new Conta();
		
		conta1.setAgencia(agencia5);
		conta2.setAgencia(agencia4);
		conta3.setAgencia(agencia3);
		conta4.setAgencia(agencia2);
		conta5.setAgencia(agencia1);
		
		
		
		
		
		
		
		
		
		
		
		
		manager.getTransaction().commit();
		manager.close();
		
	}

}
