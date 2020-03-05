package br.com.compasso.rocketEmprestimos.resources;

import java.io.IOException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

public class testaWebservice {
	
	public static void main(String[] args) throws IOException {
		 Server serrvidor = new Server();
	
		serrvidor.startServer();
		
//		server.startServer();
//		
		System.in.read();
		 Client client = ClientBuilder.newClient();
	     WebTarget target = client.target("http://localhost:8080");
	     String conteudo = target.path("/clientes").request().get(String.class);
	
	    System.out.println(conteudo);
		serrvidor.stopServer();
		
	
	}

}
