package br.com.compasso.rocketEmprestimos.dao;

import javax.persistence.EntityManager;

public class UsuarioDAO {

	private final EntityManager entityManager;
	
	public UsuarioDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
}
