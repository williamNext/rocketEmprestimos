package br.com.compasso.rocketEmprestimos.dao;

import javax.persistence.EntityManager;

import br.com.compasso.rocketEmprestimos.model.Usuario;

public class UsuarioDAO extends BaseDAO<Usuario>{

	private final EntityManager entityManager;
	
	public UsuarioDAO(EntityManager entityManager) {
		super(entityManager, Usuario.class);
		this.entityManager = entityManager;
	}
	
}
