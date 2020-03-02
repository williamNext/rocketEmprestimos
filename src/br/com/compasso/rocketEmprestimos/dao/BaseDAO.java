package br.com.compasso.rocketEmprestimos.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

public abstract class BaseDAO<T> implements CRUD<T>{
	
	@PersistenceContext
	private final EntityManager entityManager;
	private final Class<T> classe;
	
	public BaseDAO(EntityManager entityManager, Class<T> classe) {
		this.entityManager = entityManager;
		this.classe = classe;
	}
	
	@Override
	public T find(Object primaryKey) {
		return entityManager.find(classe, primaryKey);
	}
	
	@Override
	public List<T> findAll() {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<T> query = criteriaBuilder.createQuery(classe);
		query.from(classe);
		
		return entityManager.createQuery(query).getResultList();
	}
	
	@Override
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
	
	@Override
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
	
	protected EntityManager getEntityManager() {
		return entityManager;
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
