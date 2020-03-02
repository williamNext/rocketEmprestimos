package br.com.compasso.rocketEmprestimos.dao;

import javax.persistence.EntityManager;

import br.com.compasso.rocketEmprestimos.model.Conta;

public class ContaDAO extends BaseDAO<Conta>{

	public ContaDAO(EntityManager entityManager) {
		super(entityManager, Conta.class);
	}

}
