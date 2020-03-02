package br.com.compasso.rocketEmprestimos.dao;

import java.util.List;

public interface CRUD<T> {

	T find (Object primaryKey);
	List<T> findAll();
	boolean saveOrUpdate(T obj);
	boolean delete(T obj);
	
}
