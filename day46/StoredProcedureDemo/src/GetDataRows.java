

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SimpleEmployee;

/**
 * Servlet implementation class GetDataRows
 */
@WebServlet("/GetDataRows")
public class GetDataRows extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetDataRows() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String url = "jdbc:mysql://localhost:3306/classicmodels?serverTimezone=CST";
		String user = "root";
		String password = "00000000";
		
		PrintWriter out = response.getWriter();
		String city = request.getParameter("city");
//		String city = "San Francisco";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, password);
			CallableStatement cs = con.prepareCall("{CALL GetEmpInOffice(?)}");
			cs.setString(1, city);
			ResultSet rs = cs.executeQuery();
//			print(out, rs);
			
			ArrayList<SimpleEmployee> list = new ArrayList<>();
			fillList(rs, list);
			
			request.getSession().setAttribute("emps", list);
			request.getRequestDispatcher("ShowEmployeeInCity.jsp").forward(request, response);
			
			con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} 
	}
	
	protected void print(PrintWriter out, ResultSet rs) {
		out.println("<table border='1'>");
		try {
			while(rs.next()) {
				out.println("<tr><td>");
				String number = rs.getString("employeeNumber");
				out.println(number);
				out.println("</td><td>");
				String firstName = rs.getString("firstName");
				out.println(firstName);
				out.println("</td><td>");
				String lastName = rs.getString("lastName");
				out.println(lastName);
				out.println("</td><td>");
				String email = rs.getString("email");
				out.println(email);
				out.println("</td>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.println("</table>");
	}
	
	protected void fillList(ResultSet rs, ArrayList<SimpleEmployee> list) {
		try {
			while(rs.next()) {
				SimpleEmployee e = new SimpleEmployee(rs.getInt("employeeNumber"), rs.getString("firstName"), rs.getString("lastName"), rs.getString("email"));
				list.add(e);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
