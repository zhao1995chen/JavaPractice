

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;

/**
 * Servlet implementation class EmployeeEntityServlet
 */
@WebServlet("/EmployeeEntityServlet")
public class EmployeeEntityServlet extends HttpServlet {
	private String url = "jdbc:mysql://localhost:3306/classicmodels";
	private String user = "root";
	private String password = "00000000";
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeEntityServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sql = "select employeeNumber, firstName, lastName, jobTitle from classicmodels.employees";
		List<Employee> data = new ArrayList<>();
//		PrintWriter out = response.getWriter();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				int employeeNumber = rs.getInt("employeeNumber");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String jobTitle = rs.getString("jobTitle");
				Employee e = new Employee(employeeNumber, firstName, lastName, jobTitle);
				data.add(e);
			}
			
			con.close();
			request.setAttribute("emps", data);
			request.getRequestDispatcher("index.jsp").forward(request, response);
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
