package br.com.compasso.rocketEmprestimos.resources;

import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class Server {
	
	
	
	private HttpServer server;

	public void startServer() {
		
			ResourceConfig config = new ResourceConfig().packages("br.com.compasso.rocketEmprestimos.resources");
			URI uri = URI.create("http://localhost:8080/");        
			server = GrizzlyHttpServerFactory.createHttpServer(uri, config);
			System.out.println("Servidor rodando");
			
	}
	
	public void stopServer() {
		server.stop();
	}
       
}
