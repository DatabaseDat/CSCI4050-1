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
		
		if (viewMore != null){
			viewMoreInfo(request, response);
		}else if (addToCart != null){
			addToCart(request, response);
		}
	}

//--------------------ADD TO CART --------------------------------------------------------------------------------------------------------------------------------- 
	
		
	private void addToCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("userID") != null){
			int userID = (int) request.getSession().getAttribute("userID");
			long ISBN = Long.parseLong(request.getParameter("add"));
			DbLogicImpl ctrl = new DbLogicImpl();
			Book b = ctrl.getAllBookInfo(ISBN);
			ctrl.addBookToCart(b, userID);
			
			request.setAttribute("book", b);
			request.setAttribute("books", BookstoreServlet.displayBooks(request, response));
				
			if (request.getSession().getAttribute("name") != null){
				request.setAttribute("name", request.getSession().getAttribute("name"));
				String returnTo = request.getParameter("returnTo");
				request.getRequestDispatcher(returnTo).forward(request, response);
			}
		}else{
			request.setAttribute("errorMsg", "Please log in to add books to cart.");
			String returnTo = request.getParameter("returnTo");
			request.getRequestDispatcher(returnTo).forward(request, response);
		}
	}

//--------------------VIEW MORE INFO --------------------------------------------------------------------------------------------------------------------------------- 

	static void viewMoreInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long ISBN = -1;
		
		if (request.getSession().getAttribute("comingFromLogin") != null){
			ISBN = Long.parseLong(request.getSession().getAttribute("ISBN").toString());
		}else{
			ISBN = Long.parseLong(request.getParameter("moreInfo"));
		}
		
		DbLogicImpl ctrl = new DbLogicImpl();
		Book b = ctrl.getAllBookInfo(ISBN);
		request.setAttribute("book", b);
		request.setAttribute("books", BookstoreServlet.displayBooks(request, response));
			
		if (request.getSession().getAttribute("name") != null){
			request.setAttribute("name", request.getSession().getAttribute("name"));
			request.getSession().setAttribute("book", b);
			if (request.getSession().getAttribute("name") != null){
				request.setAttribute("name", request.getSession().getAttribute("name"));
				String returnTo = request.getParameter("returnTo");
				request.getRequestDispatcher(returnTo).forward(request, response);
			}		}else{
			request.getSession().invalidate();
			String returnTo = request.getParameter("returnTo");
			request.getRequestDispatcher(returnTo).forward(request, response);		}
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
