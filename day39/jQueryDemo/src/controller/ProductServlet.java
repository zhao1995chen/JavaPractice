package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		request.setCharacterEncoding("utf-8");
		String data = request.getParameter("data");

		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");

		Product[] pts;
		try {
			pts = read();
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String msg = "";
		for(Product p: pts) {
			msg += p.toString() + "<br>";
		}

		request.setAttribute("table", msg);
		request.getRequestDispatcher("table.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public void save(Product[] pts) throws IOException {
		FileOutputStream fos = new FileOutputStream("C:/Users/Zhao/Documents/JavaPractice/day39/jQueryDemo/output/pts.json");
		ObjectOutputStream oos = new ObjectOutputStream(fos);

		oos.writeObject(pts);
		oos.close();
		fos.close();
	}

	public Product[] read() throws Exception {
		FileInputStream fis = new FileInputStream("C:/Users/Zhao/Documents/JavaPractice/day39/jQueryDemo/output/pts.json");
		ObjectInputStream ois = new ObjectInputStream(fis);

		Product[] pts = (Product[]) ois.readObject();

		ois.close();
		fis.close();
		
		return pts;
	}
}
