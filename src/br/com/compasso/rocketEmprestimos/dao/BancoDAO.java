package br.com.compasso.rocketEmprestimos.dao;

import javax.persistence.EntityManager;

import br.com.compasso.rocketEmprestimos.model.Banco;

public class BancoDAO extends BaseDAO<Banco> {

	public BancoDAO(EntityManager entityManager) {
		super(entityManager, Banco.class);
	}

}
