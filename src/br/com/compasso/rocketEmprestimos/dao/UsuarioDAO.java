package br.com.compasso.rocketEmprestimos.dao;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import br.com.compasso.rocketEmprestimos.model.Usuario;

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

		return entityManager
				.createQuery(query.where(loginEqual, senhaEqual))
				.getSingleResult();
	}

}
