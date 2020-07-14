package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProductDAO {
	public ArrayList<Product> getProductList() {
		String url = "jdbc:mysql://localhost:3306/classicmodels";
		String user = "root";
		String password = "00000000";
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<Product> list = new ArrayList<>();
		String query = "select productCode as code, quantityInStock as quantity, productDescription as description, buyPrice as price from classicmodels.products"; 

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, user, password);
			st = con.createStatement();
			rs = st.executeQuery(query);
			
			while(rs.next()) {
				Product ur = new Product();
				ur.setCode(rs.getString("code"));
				ur.setQuantity(rs.getInt("quantity"));
				ur.setDescription(rs.getString("description"));
				ur.setPrice(rs.getString("price"));
				list.add(ur);
			}
			
			rs.close();
			con.close();
		} catch (ClassNotFoundException e) {
			System.out.println("No Driver");
		} catch (SQLException e) {
			System.out.println("No Connection");
		}
		
		return list;
	}
}
