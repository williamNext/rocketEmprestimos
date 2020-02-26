package br.com.compasso.rocketEmprestimos.dao;

import javax.persistence.EntityManager;

public class BaseDAO<T> {
	
	private final EntityManager entityManager;
	private final Class<T> classe;
	
	public BaseDAO(EntityManager entityManager, Class<T> classe) {
		this.entityManager = entityManager;
		this.classe = classe;
	}
	
	public EntityManager getEm() {
		return entityManager;
	}
	
	public T Find(Object PK) {
		return entityManager.find(classe, PK);
	}
	
	public void Insert(T obj) {
		entityManager.getTransaction().begin();
		entityManager.persist(obj);
		entityManager.getTransaction().commit();
	}
	
}
