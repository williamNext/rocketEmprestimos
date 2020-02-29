package br.com.compasso.rocketEmprestimos.dao;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.compasso.rocketEmprestimos.model.Cliente;

public class ClienteDAO extends BaseDAO<Cliente>{

	public ClienteDAO(EntityManager entityManager) {
		super(entityManager, Cliente.class);
	}
	
	public Cliente findByNome(String nome) {		
		CriteriaBuilder criteriaBuilder = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Cliente> query = criteriaBuilder.createQuery(Cliente.class);
		Root<Cliente> root = query.from(Cliente.class);
		
		Path<String> nomePath = root.get("nome");
		Predicate equal = criteriaBuilder.equal(nomePath, nome);
		
		return getEntityManager()
				.createQuery(query.where(equal))
				.getSingleResult();
	}
}
