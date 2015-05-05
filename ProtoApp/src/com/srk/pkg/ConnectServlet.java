package com.srk.pkg;

import java.io.*;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/ConnectServlet")
public class ConnectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int numberOfActiveUsers = 0;

    /**
     * Default constructor. 
     */
    public ConnectServlet() {
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
		// TODO Auto-generated method stub
		if (request.getAttribute("isShare") != null) {
			if ((int)request.getAttribute("isShare") == 1) {
				this.numberOfActiveUsers = (int) request.getAttribute("numberOfActiveUsers");
				return;
			}
		}
		
		this.numberOfActiveUsers++;
		request.setAttribute("numberOfActiveUsers", this.numberOfActiveUsers);
		request.setAttribute("isShare", 1);
		request.getRequestDispatcher("/DisconnectServlet").forward(request, response);
		
		Map<String, String[]> paramsDict = request.getParameterMap();
		System.out.print("uid is" + paramsDict.get("uid"));
		System.out.print("current number of active users: " + this.numberOfActiveUsers);
		
//		response.setContentType("application/json");
//		PrintWriter out1 = response.getWriter();
//		String jsonObject = "{\"messssssage\": \"hahahahhahaha\"}";
//		out1.print(jsonObject);
//		out1.flush();
//		
		
		
	}

}
