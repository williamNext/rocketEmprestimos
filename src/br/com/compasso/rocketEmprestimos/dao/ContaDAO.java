package br.com.compasso.rocketEmprestimos.dao;

import javax.persistence.EntityManager;

public class ContaDAO {

	private final EntityManager entityManager;

	public ContaDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
