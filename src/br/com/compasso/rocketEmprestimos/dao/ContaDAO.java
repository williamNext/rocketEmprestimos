package br.com.compasso.rocketEmprestimos.dao;

import javax.persistence.EntityManager;

import br.com.compasso.rocketEmprestimos.model.Conta;

public class ContaDAO extends BaseDAO<Conta>{

	private final EntityManager entityManager;

	public ContaDAO(EntityManager entityManager) {
		super(entityManager, Conta.class);
		this.entityManager = entityManager;
	}

}
