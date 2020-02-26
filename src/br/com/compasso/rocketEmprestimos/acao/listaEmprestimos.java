package br.com.compasso.rocketEmprestimos.acao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class listaEmprestimos
 */
@WebServlet("/listaEmprestimos")
public class listaEmprestimos implements Acao{

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Emprestimo> lstEmprestimos = new ArrayList<>();//ver se a classe emprestimo existe e se é esse o nome
		
		lstEmprestimos = EmprestimoDAO.getListaEmprestimos();//nome improvisado
		
		request.setAttribute("emprestimos", lstEmprestimos);
		
		return "forward:listaEmprestimos.jsp";
	}

	

}
