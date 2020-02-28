package br.com.compasso.rocketEmprestimos.dao;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.compasso.rocketEmprestimos.model.Usuario;
import br.com.compasso.rocketEmprestimos.util.Criptografador;

public class UsuarioDAO extends BaseDAO<Usuario>{

	private final EntityManager entityManager;
	
	public UsuarioDAO(EntityManager entityManager) {
		super(entityManager, Usuario.class);
		this.entityManager = entityManager;
	}
	
	public Usuario findByLoginAndSenha(String login, String senha) {
		String jpql = "select u from Usuario u where u.login = :pLogin and u.senha = :pSenha";
		TypedQuery<Usuario> query = entityManager
				.createQuery(jpql, Usuario.class);
		query.setParameter("pLogin", login);
		query.setParameter("pSenha", Criptografador.gerarHashMD5(senha));
		
		return query.getSingleResult();
	}
	
}
