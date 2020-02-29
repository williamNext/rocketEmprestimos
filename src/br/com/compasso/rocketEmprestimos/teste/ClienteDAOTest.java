package br.com.compasso.rocketEmprestimos.teste;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import br.com.compasso.rocketEmprestimos.dao.ClienteDAO;
import br.com.compasso.rocketEmprestimos.model.Cliente;
import br.com.compasso.rocketEmprestimos.util.JPAUtil;

class ClienteDAOTest {

	@Test
	void test() {
		ClienteDAO clienteDAO = new ClienteDAO(new JPAUtil().getEntityManager());
		
		List<Cliente> all = clienteDAO.findAll();
		
		all.forEach(c -> {
			System.out.println("Nome: " + c.getNome());
		});
		
		System.out.println();
		System.out.println("find by name");
		
		Cliente cliente = clienteDAO.findByNome("Kaiser");
		System.out.println("conta id: " + cliente.getConta().getId());
		System.out.println("id: " + cliente.getId());
		System.out.println("nome: " + cliente.getNome());
		System.out.println("cpf: " + cliente.getCpf());
		
		assertTrue(cliente != null);
	}

}
