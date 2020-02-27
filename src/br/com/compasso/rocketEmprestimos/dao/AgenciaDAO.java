package br.com.compasso.rocketEmprestimos.dao;

import javax.persistence.EntityManager;

import br.com.compasso.rocketEmprestimos.model.Agencia;

public class AgenciaDAO extends BaseDAO<Agencia> {

	private final EntityManager entityManager;
	
	public AgenciaDAO(EntityManager entityManager) {
		super(entityManager, Agencia.class);
		this.entityManager = entityManager;
	}
	
}
