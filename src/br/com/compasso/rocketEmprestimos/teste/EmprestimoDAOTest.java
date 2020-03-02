package br.com.compasso.rocketEmprestimos.teste;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import br.com.compasso.rocketEmprestimos.dao.EmprestimoDAO;
import br.com.compasso.rocketEmprestimos.model.Emprestimo;
import br.com.compasso.rocketEmprestimos.model.Status;
import br.com.compasso.rocketEmprestimos.util.JPAUtil;

class EmprestimoDAOTest {

	@Test
	void test() {
		EmprestimoDAO emprestimoDAO = new EmprestimoDAO(new JPAUtil().getEntityManager());
		List<Emprestimo> all = emprestimoDAO.findAll();
		
		for (Emprestimo emprestimo : all) {
			System.out.println(emprestimo.getId());
		}
		
		System.out.println("Diferentes de aprovados");
		
		List<Emprestimo> deAprovados = emprestimoDAO.findDiferentesDe(Status.APROVADO ,
																		Status.REPROVADO);
		
		deAprovados.forEach(e -> {
			System.out.println(e.getId());
		});
		
		assertTrue(deAprovados.size() > 0);
	}

}
