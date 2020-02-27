package br.com.compasso.rocketEmprestimos.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.compasso.rocketEmprestimos.model.Cliente;

public class ClienteDAO extends BaseDAO<Cliente>{

	private final EntityManager entityManager;
	
	public ClienteDAO(EntityManager entityManager) {
		super(entityManager, Cliente.class);
		this.entityManager = entityManager; 
	}
	
	public List<Cliente> findAll(){
		return entityManager
				.createQuery("select c from cliente c", Cliente.class)
				.getResultList();
	}
}
