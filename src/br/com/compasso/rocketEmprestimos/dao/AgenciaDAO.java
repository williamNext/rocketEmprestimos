package br.com.compasso.rocketEmprestimos.dao;

import javax.persistence.EntityManager;

import br.com.compasso.rocketEmprestimos.model.Agencia;

public class AgenciaDAO extends BaseDAO<Agencia> {

	public AgenciaDAO(EntityManager entityManager) {
		super(entityManager, Agencia.class);
	}

}
