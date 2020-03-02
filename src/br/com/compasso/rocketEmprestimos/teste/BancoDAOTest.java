package br.com.compasso.rocketEmprestimos.teste;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import br.com.compasso.rocketEmprestimos.dao.BancoDAO;
import br.com.compasso.rocketEmprestimos.model.Banco;
import br.com.compasso.rocketEmprestimos.util.JPAUtil;

class BancoDAOTest {

	@Test
	void test() {
		BancoDAO bancoDAO = new BancoDAO(new JPAUtil().getEntityManager());
		Banco banco = bancoDAO.find(1);
		System.out.println("=========");
		banco.getAgencias().forEach(b -> {
			System.out.println(b.getId());
			System.out.println(b.getNumero());
			System.out.println("========");
		});
		
		Banco banco2 = new Banco();
		banco2.setId(7);
		banco2.setNome("teste");
		
		assertTrue(bancoDAO.delete(banco2));
	}

}
