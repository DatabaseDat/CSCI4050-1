package boundary;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logic.DbLogicImpl;
import object.Book;

/**
 * Servlet implementation class BookstoreServlet
 */
@WebServlet("/BookHandlerServlet")
public class BookHandlerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookHandlerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String viewMore = request.getParameter("moreInfo");
		String addToCart = request.getParameter("add");
		
		System.out.println(viewMore);
		System.out.println(addToCart);
		if (viewMore != null){
			viewMoreInfo(request, response);
		}else if (addToCart != null){
			addToCart(request, response);
		}
	}

//--------------------ADD TO CART --------------------------------------------------------------------------------------------------------------------------------- 
	
		
	private void addToCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

//--------------------VIEW MORE INFO --------------------------------------------------------------------------------------------------------------------------------- 

	static void viewMoreInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int ISBN = Integer.parseInt(request.getParameter("moreInfo"));
		DbLogicImpl ctrl = new DbLogicImpl();
		Book b = ctrl.getAllBookInfo(ISBN);
		request.setAttribute("book", b);
		request.setAttribute("books", BookstoreServlet.displayBooks(request, response));
			
		if (request.getSession().getAttribute("name") != null){
			System.out.println("reg");
			request.setAttribute("name", request.getSession().getAttribute("name"));
			request.getRequestDispatcher("bookInfoRegistered.jsp").forward(request, response);
		}else{
			System.out.println("unreg");
			request.getRequestDispatcher("bookInfoUnregistered.jsp").forward(request, response);
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
