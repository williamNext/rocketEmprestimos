package br.com.compasso.rocketEmprestimos.util;

import javax.persistence.EntityManager;

import br.com.compasso.rocketEmprestimos.model.Banco;

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
		
		
		
		
		
		
		manager.getTransaction().commit();
		manager.close();
		
	}

}
