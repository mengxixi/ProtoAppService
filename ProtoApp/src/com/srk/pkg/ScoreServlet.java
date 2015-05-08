package com.srk.pkg;

import java.io.IOException;
import java.io.PrintWriter;

import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ScoreServlet
 */
@WebServlet("/ScoreServlet")
public class ScoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final int MAX_USERS = 2;

	private int totalScore = -1;
	private int numberOfScoresSubmitted = 0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScoreServlet() {
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
		int isFromQuestioningTeam = Integer.valueOf(request.getParameter("is_questioning"));
		int isWaitingForFeedback = Integer.valueOf(request.getParameter("is_waiting"));
		int singleScore = Integer.valueOf(request.getParameter("score"));
		
		if (isFromQuestioningTeam == 0){
			if (isWaitingForFeedback == 0) {
				// sending scores in, compute
				this.numberOfScoresSubmitted++;
				this.totalScore += singleScore;
			} 
		} 
		
		JsonObject json;
		
		if (this.numberOfScoresSubmitted == MAX_USERS/2){
			// got enough, send back
			double averageScore = this.totalScore/(MAX_USERS/2);
			
			json = Json.createObjectBuilder()
					.add("is_score_ready", true)
					.add("avg_score", averageScore).build();
			response.setContentType("application/json");
			PrintWriter out1 = response.getWriter();
			out1.print(json.toString());
			out1.flush();
			return;
			
		} else {
			// not enough, notify user
		}
		

		
	}

}
