
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


import model.*;

/**
 * Servlet implementation class QueryEmpServlet
 */
@WebServlet("/QueryEmpServlet")
public class QueryEmpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private   SessionFactory factory;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public QueryEmpServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		try {
			factory = new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}

		Session session = factory.openSession();
		 List list = session.createQuery("FROM Book").list(); 
		 Book cf = (Book)list.get(0);
		 
	        System.out.println(list);
	        response.setContentType("text/html;charset=UTF-8");
	        try (PrintWriter out = response.getWriter()) {
	            /* TODO output your page here. You may use following sample code. */
	            out.println("<!DOCTYPE html>");
	            out.println("<html>");
	            out.println("<head>");
	            out.println("<title>Servlet QueryServlet</title>");            
	            out.println("</head>");
	            out.println("<body>");
	            out.println("<h1>Servlet QueryServlet at " +list.get(0).toString() + "</h1>");
	            out.println("</body>");
	            out.println("</html>");
	        }

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
