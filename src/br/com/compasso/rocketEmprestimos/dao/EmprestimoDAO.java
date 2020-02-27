package br.com.compasso.rocketEmprestimos.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.compasso.rocketEmprestimos.model.Emprestimo;
import br.com.compasso.rocketEmprestimos.model.Status;

public class EmprestimoDAO extends BaseDAO<Emprestimo>{

	private final EntityManager entityManager;
	
	public EmprestimoDAO(EntityManager entityManager) {
		super(entityManager, Emprestimo.class);
		this.entityManager = entityManager;
	}
	
	public List<Emprestimo> findAll(){
		return entityManager
				.createQuery("select e from emprestimo e", Emprestimo.class)
				.getResultList();
	}
	
	public List<Emprestimo> findDiferentesDeAprovados(){
		String jpql = "select e from emprestimo e where e.status <> :pStatus";
		
		TypedQuery<Emprestimo> query = entityManager.createQuery(jpql, Emprestimo.class);
		query.setParameter("pStatus", Status.APROVADO);
		
		return query.getResultList();
	}
	
}
