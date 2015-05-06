package com.srk.pkg;

import java.io.IOException;
import java.util.ArrayList;

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
	private ArrayList<String> activeUsers = new ArrayList<String>();
       
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
		
		String uid = request.getParameter("uid");
		if (uid != null){// && !this.activeUsers.contains(uid)){	/****************/
			activeUsers.remove(uid);
			this.numberOfActiveUsers--;

			this.getServletContext().setAttribute("numberOfActiveUsers", this.numberOfActiveUsers);
			this.getServletContext().setAttribute("activeUsers", this.activeUsers);
			
			System.out.println("uid is: " + uid + "\n");
			System.out.println("current # of active users: " + this.numberOfActiveUsers + "\n");

		}
				
	}

}
