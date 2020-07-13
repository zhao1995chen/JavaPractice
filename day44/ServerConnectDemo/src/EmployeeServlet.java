

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private String url = "jdbc:mysql://localhost:3306/classicmodels";
	private String user = "root";
	private String password = "00000000";
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String sql = "select employeeNumber, firstName, lastName, jobTitle from classicmodels.employees";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			out.write("<!DOCTYPE html>");
			out.write("<html>");
			out.write("<head>");
			out.write("<meta charset=utf-8>");
			out.write("<title>Classicmodels DB</title>");
			out.write("</head><body>");
			out.write("<table border='1'>");
			out.write("<tr><th>");
			out.write("Employee Number");
			out.write("</th><th>");
			out.write("First Name");
			out.write("</th><th>");
			out.write("Last Name");
			out.write("</th><th>");
			out.write("Job Title");
			out.write("</th></tr>");
			
			while(rs.next()) {
				out.write("<tr><td>");
				out.write("" + rs.getInt("employeeNumber")); // write() 輸出必須是字串模式
				out.write("</td><td>");
				out.write(rs.getString("firstName"));
				out.write("</td><td>");
				out.write(rs.getString("lastName"));
				out.write("</td><td>");
				out.write(rs.getString("jobTitle"));
				out.write("</td>");
				out.write("</td></tr>");
			}
			out.write("</table></body></html>");
		} catch (ClassNotFoundException e) {
			System.out.println("No Driver");
		} catch (SQLException e) {
			System.out.println("No Connection");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
