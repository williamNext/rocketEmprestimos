package br.com.compasso.rocketEmprestimos.dao;

import javax.persistence.EntityManager;

public class ClienteDAO {

	private final EntityManager entityManager;
	
	public ClienteDAO(EntityManager entityManager) {
		this.entityManager = entityManager; 
	}
}
