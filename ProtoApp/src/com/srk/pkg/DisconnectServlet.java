package com.srk.pkg;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DisconnectServlet
 */
@WebServlet("/DisconnectServlet")
public class DisconnectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int numberOfActiveUsers = 0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisconnectServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (request.getAttribute("isShare") != null) {
			if ((int)request.getAttribute("isShare") == 1) {
				this.numberOfActiveUsers = (int) request.getAttribute("numberOfActiveUsers");
				return;
			}
		}
		
		this.numberOfActiveUsers--;
		request.setAttribute("isShare", 1);
		request.setAttribute("numberOfActiveUsers", this.numberOfActiveUsers);
		request.getRequestDispatcher("/ConnectServlet").forward(request, response);
				
	}

}
