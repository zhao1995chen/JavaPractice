package controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.Product;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // set encoding mode
		String data = request.getParameter("data");
		
		response.setContentType("text/html;charser=utf-8");
		response.setCharacterEncoding("utf-8");
//		response.getWriter().append(data);
		
		Gson g = new Gson();
		Product[] pts = g.fromJson(data, Product[].class);
		
		save(pts);
		
		String msg = "";
		for(Product p: pts) {
			msg += p.toString() + "<br>";
		}
		
		response.getWriter().append(msg);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public void save(Product[] pts) throws IOException {
		FileOutputStream fos = new FileOutputStream("C:/Users/Zhao/Documents/JavaPractice/day38/JsonObject/output/pts.bin");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(pts);
		oos.close();
		fos.close();
	}
}
