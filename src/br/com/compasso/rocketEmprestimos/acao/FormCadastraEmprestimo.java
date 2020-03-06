package br.com.compasso.rocketEmprestimos.acao;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import br.com.compasso.rocketEmprestimos.mapjson.ClienteMap;

public class FormCadastraEmprestimo implements Acao {

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		EntityManager em = (EntityManager) request.getAttribute("entityManager");		
//		ClienteDAO clienteDAO = new ClienteDAO(em);
//		List<Cliente> clientes = clienteDAO.findAll();
		 Client client = ClientBuilder.newClient();
		 WebTarget target = client.target("http://localhost:8090");
		 String conteudo = target.path("/clientes").request().get(String.class);
		
		List<ClienteMap> clientes = new Gson().fromJson(conteudo, new TypeToken<List<ClienteMap>>() {}.getType());
		
		request.setAttribute("clientes", clientes);
		
		return "forward:cadastraEmprestimo.jsp";
	}
}

