package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import myprog.MyCalculation;

/**
 * Servlet implementation class GuessController
 */
@WebServlet("/GuessController")
public class GuessController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuessController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int sys = MyCalculation.range(1, 10);
		String gs = request.getParameter("guessNumber");
		int guess = Integer.parseInt(gs);
		
		// SHOW ON CONTROLLER
//		if(guess == sys) {
//			response.getWriter().append("Bingo!");
//		} else {
//			response.getWriter().append("Wrong Guess. Real Answer is " + sys);
//		}
		
		// SHOW ON JSP VIEW
		String msg = "";
		if(guess == sys) {
			msg = "Bingo!";
		} else {
			msg = "Wrong Guess. Real Answer is " + sys;
		}
		request.setAttribute("msg", msg);
		request.getRequestDispatcher("GuessView.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
