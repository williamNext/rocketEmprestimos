package br.com.compasso.rocketEmprestimos.teste;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import br.com.compasso.rocketEmprestimos.dao.UsuarioDAO;
import br.com.compasso.rocketEmprestimos.model.Usuario;
import br.com.compasso.rocketEmprestimos.util.JPAUtil;

class UsuarioDAOTest {

	@Test
	void test() {
		UsuarioDAO usuarioDAO = new UsuarioDAO(new JPAUtil().getEntityManager());

		Usuario usuario = usuarioDAO.findByLoginAndSenha("admin", "admin");
		System.out.println(usuario.getId());
		System.out.println(usuario.getLogin());

		assertTrue(usuario != null);

	}

}
