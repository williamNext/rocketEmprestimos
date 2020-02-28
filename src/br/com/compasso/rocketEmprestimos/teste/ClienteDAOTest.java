package br.com.compasso.rocketEmprestimos.teste;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import br.com.compasso.rocketEmprestimos.dao.ClienteDAO;
import br.com.compasso.rocketEmprestimos.model.Cliente;
import br.com.compasso.rocketEmprestimos.util.JPAUtil;

class ClienteDAOTest {

	@Test
	void test() {
		ClienteDAO clienteDAO = new ClienteDAO(new JPAUtil().getEntityManager());
		Cliente cliente = clienteDAO.findByNome("Kaiser");
		
		System.out.println(cliente);
		System.out.println(cliente.getConta().getId());
		System.out.println(cliente.getConta());
		System.out.println(cliente.getNome());
		System.out.println(cliente.getCpf());
		System.out.println(cliente.getId());
		
		assertTrue(true);
	}

}
