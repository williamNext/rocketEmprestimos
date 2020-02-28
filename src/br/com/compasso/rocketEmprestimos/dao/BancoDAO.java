package br.com.compasso.rocketEmprestimos.dao;

import javax.persistence.EntityManager;

public class BancoDAO {

	private final EntityManager entityManager;
	
	public BancoDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
}
