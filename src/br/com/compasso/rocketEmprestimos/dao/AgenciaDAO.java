package br.com.compasso.rocketEmprestimos.dao;

import javax.persistence.EntityManager;

public class AgenciaDAO {

	private final EntityManager entityManager;
	
	public AgenciaDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	
	
}
