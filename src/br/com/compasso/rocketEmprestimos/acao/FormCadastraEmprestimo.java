package br.com.compasso.rocketEmprestimos.acao;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.compasso.rocketEmprestimos.dao.ClienteDAO;
import br.com.compasso.rocketEmprestimos.model.Cliente;

public class FormCadastraEmprestimo implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		EntityManager em = (EntityManager) request.getAttribute("entityManager");		
		ClienteDAO clienteDAO = new ClienteDAO(em);
		
		List<Cliente> clientes = clienteDAO.findAll();
		request.setAttribute("clientes", clientes);
		
		return "forward:cadastraEmprestimo.jsp";
	}
}

