package br.com.compasso.rocketEmprestimos.teste;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import br.com.compasso.rocketEmprestimos.dao.AgenciaDAO;
import br.com.compasso.rocketEmprestimos.model.Agencia;
import br.com.compasso.rocketEmprestimos.util.JPAUtil;

class AgenciaDAOTest {

	@Test
	void test() {
		AgenciaDAO agenciaDAO = new AgenciaDAO(new JPAUtil().getEntityManager());
		Agencia agencia = agenciaDAO.find(1);
		
		System.out.println(agencia.getBanco().getNome());
		assertTrue(true);
	}

}
