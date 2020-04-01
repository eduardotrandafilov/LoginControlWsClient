package org.ws.logincontrol.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.ws.logincontrol.webservices.UserWs;
import org.ws.logincontrol.webservices.UserWsServiceLocator;

/**
 * Servlet implementation class LoginControlServlet
 */
@WebServlet("/LoginControlServlet")
public class LoginControlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginControlServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String resultadoJSP = null;
		try {
			String email = request.getParameter("email");
			String senha = request.getParameter("senha");
			
			UserWsServiceLocator locator = new UserWsServiceLocator();
			
			UserWs stub  = locator.getUserWsPort();
			
			String nome = stub.findUser(email, senha);
			
			
			if (nome!=null) {
				resultadoJSP = "/sucesso.jsp";
				request.setAttribute("nome", nome);
			} else {
				
				resultadoJSP = "/erro.jsp";
			}
		
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(resultadoJSP);
			
			dispatcher.forward(request, response);
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}

	}

}
