package br.com.compasso.rocketEmprestimos.controller;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import br.com.compasso.rocketEmprestimos.util.JPAUtil;

//@WebFilter("/emprestimos")
public class ControleBancoFilter implements Filter {

	public void destroy() {	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		System.out.println("ControleBancoFilter");
		
		EntityManager entityManager = new JPAUtil().getEntityManager();
		request.setAttribute("entityManager", entityManager);
		
		chain.doFilter(request, response);
		entityManager.close();
	}

	public void init(FilterConfig fConfig) throws ServletException { }

}
