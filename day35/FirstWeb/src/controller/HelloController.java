package controller;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.HelloMessage;

/**
 * Servlet implementation class helloServlet
 */
//@WebServlet("/helloServlet")
@WebServlet(name="HelloController", urlPatterns= {"/hello.do"})
public class HelloController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private HelloMessage hello = new HelloMessage();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("username");
		String msg = hello.sayHello(name);
		request.setAttribute("msg", msg);
		RequestDispatcher disp = request.getRequestDispatcher("HelloView.jsp");
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("username");
		String msg = hello.sayHello(name);
		request.setAttribute("msg", msg);
		RequestDispatcher disp = request.getRequestDispatcher("HelloView.jsp");
		disp.forward(request, response);
	}

}
