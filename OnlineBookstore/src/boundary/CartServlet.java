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
import object.ShoppingCart;

/**
 * Servlet implementation class BookstoreServlet
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
		
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
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
		String display = request.getParameter("displayCart");
		String deleteItem = request.getParameter("delete");
		String updateCart = request.getParameter("updateCart");
		if (display != null) {
			displayCart (request, response);
		}else if (deleteItem != null){
			deleteItem(request, response);
		}else if (updateCart != null){
			updateCart(request, response);
		}
	}

//--------------------DISPLAY CART---------------------------------------------------------------------------------------------------------------------------------- 
	private void displayCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getSession().getAttribute("userID") != null){
			int userID = (int) request.getSession().getAttribute("userID");
			double total = 0;
			
			DbLogicImpl ctrl = new DbLogicImpl();
			ArrayList<ShoppingCart> booksInCart = new ArrayList<ShoppingCart>();
			booksInCart = ctrl.getBooksFromCart(userID);	
			for (ShoppingCart s : booksInCart){
				total += s.getPrice();
			}
			
			total = Math.round(total * 100.0) / 100.0;
			
			request.setAttribute("total", total);
			request.setAttribute("booksInCart", booksInCart);
			request.setAttribute("name", request.getSession().getAttribute("name"));
			request.getRequestDispatcher("cart.jsp").forward(request, response);
		}else{
			request.setAttribute("errorMsg", "You must log in to add books to cart or to view cart.");
			String returnTo = request.getParameter("returnTo");
			request.getRequestDispatcher(returnTo).forward(request, response);
		}
	}
	
//--------------------DELETE ITEM FROM CART---------------------------------------------------------------------------------------------------------------------------------- 
	private void deleteItem(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DbLogicImpl ctrl = new DbLogicImpl();
		ctrl.deleteBook(Integer.parseInt(request.getParameter("bookToDelete")));
		int userID = (int) request.getSession().getAttribute("userID");
		double total = 0;
		
		ArrayList<ShoppingCart> booksInCart = new ArrayList<ShoppingCart>();
		booksInCart = ctrl.getBooksFromCart(userID);	
		for (ShoppingCart s : booksInCart){
			total += s.getPrice();
		}
		
		total = Math.round(total * 100.0) / 100.0;
		
		request.setAttribute("total", total);
		request.setAttribute("booksInCart", booksInCart);
		request.setAttribute("name", request.getSession().getAttribute("name"));
		request.getRequestDispatcher("cart.jsp").forward(request, response);
	}
	
//--------------------UPDATE CART---------------------------------------------------------------------------------------------------------------------------------- 	
	private void updateCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DbLogicImpl ctrl = new DbLogicImpl();
		request.getSession().getAttribute("userID");
		System.out.println("bookID: " + Integer.parseInt(request.getParameter("bookToUpdate")));
		int cartID = Integer.parseInt(request.getParameter("bookToUpdate"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		ctrl.updateCart(cartID, quantity);
		int userID = (int) request.getSession().getAttribute("userID");
		double total = 0;
		
		ArrayList<ShoppingCart> booksInCart = new ArrayList<ShoppingCart>();
		booksInCart = ctrl.getBooksFromCart(userID);	
		for (ShoppingCart s : booksInCart){
			total += s.getPrice();
		}
		
		total = Math.round(total * 100.0) / 100.0;
		
		request.setAttribute("total", total);
		request.setAttribute("booksInCart", booksInCart);
		request.setAttribute("name", request.getSession().getAttribute("name"));
		request.getRequestDispatcher("cart.jsp").forward(request, response);
	}
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
