package br.com.compasso.rocketEmprestimos.acao;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class aprovaEmprestimo
 */
@WebServlet("/aprovaEmprestimo")
public class aprovaEmprestimo implements Acao{//extends HttpServelt

	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//revisar essa classe
		
		Emprestimo emprestimo = banco.pegaEmprestimoPeloID();
		emprestimo.setStatusEmprestimo(statusEmprestimo.APROVADO);

		
		
		return "forward:aprovaEmprestimo.jsp";
		
	}


}
