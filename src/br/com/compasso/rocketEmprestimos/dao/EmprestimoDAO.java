package br.com.compasso.rocketEmprestimos.dao;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.compasso.rocketEmprestimos.model.Emprestimo;

public class EmprestimoDAO {

	private final EntityManager entityManager;
	
	public EmprestimoDAO(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	public List<Emprestimo> findAll(){
		return entityManager
				.createQuery("select e from emprestimo e", Emprestimo.class)
				.getResultList();
	}
	
}
