

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertCoffeeServlet
 */
@WebServlet("/InsertCoffeeServlet")
public class InsertCoffeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertCoffeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @throws IOException 
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		try {
			out.println("<!DOCTYPE html>");
	        out.println("<html>");
	        out.println("<head>");
	        out.println("<title>Servlet InsertCoffee</title>");            
	        out.println("</head>");
	        out.println("<body>");
	        
	        String coffee = request.getParameter("coffee");
	        String sale = request.getParameter("sale");
	        String total = request.getParameter("total");
	        String supplier = request.getParameter("supplier");
	        String price = request.getParameter("price");
	        
	        int rs = 0;
	        rs = insertCoffee(coffee, sale, total, supplier, price);
	        if(rs > 0) {
	        	out.println("輸入完成");
	        } else {
	        	out.println("輸入失敗");
	        }
	        
	        out.println("</body>");
            out.println("</html>");
		} finally {
			out.close();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	public int insertCoffee(String coffee, String sale, String total, String supplier, String price) {
		String url = "jdbc:mysql://localhost:3306/test";
		String user = "root";
		String password = "00000000";
		Connection con = null;
		PreparedStatement ps = null;
		String sql = "insert into coffees(cof_name, sup_id, price, sales, total) values (?, ?, ?, ?, ?)";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			con.setAutoCommit(false); // Transaction 自動更新 commit
			ps = con.prepareStatement(sql);
			
//			for(Map.Entry<String, Integer> e: salesForWeek.entrySet()) { }
			ps.setString(1, coffee);
			ps.setInt(2, Integer.parseInt(supplier));
			ps.setDouble(3, Double.parseDouble(price));
			ps.setInt(4, Integer.parseInt(sale));
			ps.setInt(5, Integer.parseInt(total));
			
			int rs = ps.executeUpdate();
			con.commit();
			return rs;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			if(con != null) {
				try {
					System.err.print("Transaction is being rolled back");
					con.rollback();
				} catch (SQLException ex) { // 對於 debug 方便 >> 使用 try/catch 才能抓訊息
					System.out.println(ex.getMessage());
				}
			}
		} finally {
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			}
			try {
				con.setAutoCommit(true);
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return 0;
	}
}
