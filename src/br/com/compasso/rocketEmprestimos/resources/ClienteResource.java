package br.com.compasso.rocketEmprestimos.resources;

import java.util.List;

import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

import br.com.compasso.rocketEmprestimos.dao.ClienteDAO;
import br.com.compasso.rocketEmprestimos.model.Cliente;
import br.com.compasso.rocketEmprestimos.util.JPAUtil;

@Path("clientes")
public class ClienteResource {

	@GET
	@Produces(MediaType.APPLICATION_XML)
	public String getClientes() {

	
		EntityManager em = new JPAUtil().getEntityManager();
		ClienteDAO clienteDao = new ClienteDAO(em);
		List<Cliente> clientes = clienteDao.findAll();
		System.out.println(new Gson().toJson(clientes));
		
		em.close();
		String xml = new XStream().toXML(clientes);
		return xml;
	}

}
