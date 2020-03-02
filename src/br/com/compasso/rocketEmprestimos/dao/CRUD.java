package br.com.compasso.rocketEmprestimos.dao;

public interface CRUD<T> {

	T find (Object primaryKey);
	boolean saveOrUpdate(T obj);
	boolean delete(T obj);
	
}
