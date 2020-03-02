package br.com.compasso.rocketEmprestimos.acao;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.compasso.rocketEmprestimos.dao.ClienteDAO;
import br.com.compasso.rocketEmprestimos.model.Cliente;
import br.com.compasso.rocketEmprestimos.util.JPAUtil;

public class FormCadastraEmprestimo implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		EntityManager em  = new JPAUtil().getEntityManager();
		
		ClienteDAO clienteDAO = new ClienteDAO(em);
		
		List<Cliente> clientes = clienteDAO.findAll();
		
		em.close();
		
		request.setAttribute("clientes", clientes);
		
		
		return "forward:cadastraEmprestimo.jsp";
	}

	
	
}

