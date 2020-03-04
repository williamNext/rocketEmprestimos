package br.com.compasso.rocketEmprestimos.controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebFilter("/entrada")
public class AutorizacaoFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("AutorizacaoFilter");
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String paramAcao = request.getParameter("acao");
		
		HttpSession session = request.getSession();
		
		boolean usuarioNaoLogado = session.getAttribute("usuarioLogado") == null;
		boolean isUmaAcaoProtegida = !(paramAcao != null && paramAcao.equals("ValidaLogin") || paramAcao.equals("FormLogin"));
		
		if(usuarioNaoLogado && isUmaAcaoProtegida) {
			response.sendRedirect("emprestimos?acao=FormLogin");
			return;
		}
		
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
