package br.com.compasso.rocketEmprestimos.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.compasso.rocketEmprestimos.model.Cliente;

public class ClienteDAO extends BaseDAO<Cliente>{

	private final EntityManager entityManager;
	
	public ClienteDAO(EntityManager entityManager) {
		super(entityManager, Cliente.class);
		this.entityManager = entityManager; 
	}
	
	public List<Cliente> findAll(){
		return entityManager
				.createQuery("select c from Cliente c", Cliente.class)
				.getResultList();
	}
	
	public Cliente findByNome(String nome) {
		TypedQuery<Cliente> query = entityManager
				.createQuery("select c from Cliente c where c.nome = :pNome", Cliente.class);
		query.setParameter("pNome", nome);
		
		return query.getSingleResult();
	}
}
