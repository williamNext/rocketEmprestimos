package br.com.compasso.rocketEmprestimos.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;

import br.com.compasso.rocketEmprestimos.dao.ClienteDAO;
import br.com.compasso.rocketEmprestimos.mapjson.ClienteMap;
import br.com.compasso.rocketEmprestimos.model.Cliente;
import br.com.compasso.rocketEmprestimos.util.JPAUtil;

@Path("clientes")
public class ClienteService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getAll() {
		EntityManager entityManager = null;

		try {
			entityManager = new JPAUtil().getEntityManager();
			ClienteDAO clienteDAO = new ClienteDAO(entityManager);
			List<Cliente> clientes = clienteDAO.findAll();
			List<ClienteMap> clienteMaps = new ArrayList<>();
			
			for (Cliente cliente : clientes) {
				clienteMaps.add(new ClienteMap(cliente.getId(), cliente.getNome(), cliente.getCpf()));
			}
			
			return new Gson().toJson(clienteMaps);
		}catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String getById(@PathParam("id") Integer id) {
		EntityManager entityManager = null;

		try {
			entityManager = new JPAUtil().getEntityManager();
			ClienteDAO clienteDAO = new ClienteDAO(entityManager);
			Cliente cliente = clienteDAO.find(id);
			ClienteMap clienteMap = new ClienteMap(cliente.getId(), cliente.getNome(), cliente.getCpf());
			return new Gson().toJson(clienteMap);
		} finally {
			if (entityManager != null) {
				entityManager.close();
			}
		}
	}
}