package br.com.compasso.rocketEmprestimos.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
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
	
	public List<Cliente> findAllService(){
		String jpql = "select c from Cliente c join fetch c.conta ct join fetch ct.agencia a join fetch a.banco";
		Query query = getEntityManager().createQuery(jpql);
		
		return query.getResultList();
		
	}
}
