package br.com.compasso.rocketEmprestimos.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.compasso.rocketEmprestimos.model.Emprestimo;
import br.com.compasso.rocketEmprestimos.model.Status;

public class EmprestimoDAO extends BaseDAO<Emprestimo> {

	public EmprestimoDAO(EntityManager entityManager) {
		super(entityManager, Emprestimo.class);
		
	}
	
	public List<Emprestimo> findDiferentesDe(Status... status){
		
		if(status == null || status.length == 0) {
			throw new IllegalArgumentException("Argumento status está vazio");
		}
		
		CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Emprestimo> query = criteriaBuilder.createQuery(Emprestimo.class);
		Root<Emprestimo> root = query.from(Emprestimo.class);
		
		Path<Status> nomePath = root.get("status");
		Predicate[] predicados = new Predicate[status.length];
		
		for (int i = 0; i < status.length; i++) {
			predicados[i] = criteriaBuilder.notEqual(nomePath, status[i]);
		}
		
		return getEntityManager()
				.createQuery(query.where(predicados))
				.getResultList();
	}

}
