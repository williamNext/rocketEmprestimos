package br.com.compasso.rocketEmprestimos.dao;

import javax.persistence.EntityManager;

import br.com.compasso.rocketEmprestimos.model.Banco;

public class BancoDAO extends BaseDAO<Banco> {

	private final EntityManager entityManager;
	
	public BancoDAO(EntityManager entityManager) {
		super(entityManager, Banco.class);
		this.entityManager = entityManager;
	}
	
}
