package br.com.compasso.rocketEmprestimos.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.compasso.rocketEmprestimos.model.Conta;
import br.com.compasso.rocketEmprestimos.util.JPAUtil;

public class ContaDAO {

	
	public List<Conta> BuscaContas() {
		
		EntityManager em = new JPAUtil().getEntityManager();
        em.getTransaction().begin();

        Conta conta = em.find(Conta.class, 1);

        em.getTransaction().commit();
        em.close();
        
		return null;
	}
	
	
	
}
