package br.com.compasso.rocketEmprestimos.util;

import java.io.IOException;
import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class ServidorWebServices {

	public static void main(String[] args) throws IOException {
		 
        HttpServer server = initialize();
        System.out.println("Servidor rodando");
        System.in.read();
        server.stop();
    }

    public static HttpServer initialize() {
        ResourceConfig config = new ResourceConfig().packages("br.com.compasso.rocketEmprestimos.service");
        URI uri = URI.create("http://localhost:8090/");
        return GrizzlyHttpServerFactory.createHttpServer(uri, config);
    }
	
}
