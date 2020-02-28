package br.com.compasso.rocketEmprestimos.dao;

public interface CRUD<T> {

	T find (T obj);
	boolean saveOrUpdate(T obj);
	boolean delete(T obj);
	
}
