

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.MyProduct;

/**
 * Servlet implementation class MyProductServlet
 */
@WebServlet("/MyProductServlet")
public class MyProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		MyProduct product = new MyProduct("Apple", 100);
//		request.setAttribute("product", product);
//		request.getRequestDispatcher("pview.jsp").forward(request, response);
		
		List<MyProduct> data = new ArrayList<>();
		data.add(new MyProduct("Apple", 100));
		data.add(new MyProduct("Grape", 300));
		data.add(new MyProduct("Cherry", 1500));
		request.setAttribute("products", data);
		request.getRequestDispatcher("pviews.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
