package br.com.compasso.rocketEmprestimos.dao;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.compasso.rocketEmprestimos.model.Usuario;
import br.com.compasso.rocketEmprestimos.util.Criptografador;

public class UsuarioDAO extends BaseDAO<Usuario> {

	private final EntityManager entityManager;

	public UsuarioDAO(EntityManager entityManager) {
		super(entityManager, Usuario.class);
		this.entityManager = entityManager;
	}

	public Usuario findByLoginAndSenha(String login, String senha) {
		CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Usuario> query = criteriaBuilder.createQuery(Usuario.class);
		Root<Usuario> root = query.from(Usuario.class);

		Path<String> loginPath = root.get("login");
		Path<String> senhaPath = root.get("senha");

		Predicate loginEqual = criteriaBuilder.equal(loginPath, login);
		Predicate senhaEqual = criteriaBuilder.equal(senhaPath, Criptografador.gerarHashMD5(senha));
<<<<<<< HEAD
		try {
			return entityManager
					.createQuery(query.where(loginEqual, senhaEqual))
					.getSingleResult();
		} catch (Exception e) {
			return null;
		}
||||||| f42ed24

		return entityManager
				.createQuery(query.where(loginEqual, senhaEqual))
				.getSingleResult();
=======

		try {
			return entityManager
					.createQuery(query.where(loginEqual, senhaEqual))
					.getSingleResult();
		}catch (Exception e) {
			System.out.println(e.getMessage());;
		}
		
		return null;
>>>>>>> 5eca52ba99091b0f4d692b79c4bddcaab0f05437
	}

}
