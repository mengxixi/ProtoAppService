package com.srk.pkg;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

import com.srk.pkg.Team;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;
/**
 * Servlet implementation class MyServlet
 */
@WebServlet("/ConnectServlet")
public class ConnectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int numberOfActiveUsers = 0;
	private ArrayList<String> activeUsers = new ArrayList<String>();
	private Team team1 = new Team();
	private Team team2 = new Team();

	private static final int MAX_USERS = 6;
	
	
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
		
		String uid = request.getParameter("uid");
		if (uid != null){// && !this.activeUsers.contains(uid)){	/****************/
			activeUsers.add(uid);
			this.numberOfActiveUsers++;

			this.getServletContext().setAttribute("numberOfActiveUsers", this.numberOfActiveUsers);
			this.getServletContext().setAttribute("activeUsers", this.activeUsers);
			
			System.out.println("uid is: " + uid + "\n");
			System.out.println("current # of active users: " + this.numberOfActiveUsers + "\n");

		}
		
//		while (this.numberOfActiveUsers != MAX_USERS) {
//			
//		}
		
		if (this.numberOfActiveUsers == MAX_USERS){
			System.out.println("GOT ENOUGH!!!!");
			//assign teams to the six users
			this.team1.setMembers((ArrayList<String>)this.activeUsers.subList(0, 2));
			this.team1.setTeamNumber(1);
			this.team2.setMembers((ArrayList<String>)this.activeUsers.subList(3, 5));
			this.team2.setTeamNumber(2);
			
			//randomly select a questioning team
			Random rgen = new Random(System.currentTimeMillis());
			boolean rbool = rgen.nextBoolean();
			team1.setQuestioning(rbool);
			team2.setQuestioning(!rbool);
	
			// assign a captain to the questioning team
			if (team1.isQuestioning()){
				team1.selectCaptain();
			} else {
				team2.selectCaptain();
			}
			
			// return information to the user in a json format
			JSONObject json = new JSONObject();
			int teamNum;
			Boolean isQuestioning;
			Boolean isCaptain;
			
			if (team1.getMembers().contains(uid)){
				isQuestioning = team1.isQuestioning();
				teamNum = 1;
				isCaptain = team1.getCaptain().equals(uid);
			} else {
				isQuestioning = team2.isQuestioning();
				teamNum = 2;
				isCaptain = team2.getCaptain().equals(uid);
			}
			
			try {
				json.put("uid", uid)
					.put("team_num", teamNum)
					.put("is_questioning", isQuestioning)
					.put("is_captain", isCaptain);
			} catch (JSONException e) {
				e.printStackTrace();
			}
			
			response.setContentType("application/json");
			PrintWriter out1 = response.getWriter();
			out1.print(json.toString());
			out1.flush();
			
		}

		
		
	}
	
}

