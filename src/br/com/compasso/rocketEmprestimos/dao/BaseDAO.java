package br.com.compasso.rocketEmprestimos.dao;

import javax.persistence.EntityManager;

public class BaseDAO<T> implements CRUD<T>{
	
	private final EntityManager entityManager;
	private final Class<T> classe;
	
	public BaseDAO(EntityManager entityManager, Class<T> classe) {
		this.entityManager = entityManager;
		this.classe = classe;
	}
	
	public EntityManager getEm() {
		return entityManager;
	}
	
	public T find(Object PK) {
		return entityManager.find(classe, PK);
	}
	
	public boolean saveOrUpdate(T obj) {
		begin();
		
		try {
			obj = entityManager.merge(obj);
			entityManager.persist(obj);
			commit();
			return true;
		}catch (Exception e) {
			rollback();
		}
		
		return false;
	}
	
	public boolean delete(T obj) {
		begin();
		
		try {
			obj = entityManager.merge(obj);
			entityManager.remove(obj);
			commit();
			return true;
		}catch (Exception e) {
			rollback();
		}
		
		return false;
	}
	
	private void begin() {
		entityManager.getTransaction().begin();
	}
	
	private void commit() {
		entityManager.getTransaction().commit();
	}
	
	private void rollback() {
		entityManager.getTransaction().rollback();
	}
}
