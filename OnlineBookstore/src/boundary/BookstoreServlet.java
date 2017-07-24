//
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
@WebServlet("/BookstoreServlet")
public class BookstoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int firstCall = 0;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookstoreServlet() {
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
		if (firstCall == 0){
			displayAll(request, response);
		}else{
			String login = request.getParameter("login");
			String register = request.getParameter("register");
			String logout = request.getParameter("logout");
			if (login != null) {
				login (request, response);
			}else if (register != null){
				register (request, response);
			}else if (logout != null){
				logout(request, response);
			}
		}
	}

//--------------------LOGIN --------------------------------------------------------------------------------------------------------------------------------- 
	public void login(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		// Create a session object if it is already not  created.
	      HttpSession session = request.getSession(true);
	      
	      // Check if this is new comer on your web page.
	      if (session.isNew()) {
	    	  System.out.println("here");
	    	  String username = request.getParameter("username");
	    	  String password = request.getParameter("password");
		  		
	    	  String hash = SecureLogin.Hash(password);
		  		
	    	  DbLogicImpl ctrl = new DbLogicImpl();
	    	  //success = 1 means the user was found with matching password and is allowed to log in
		      //success = 0 means incorrect login or password
	    	  int success = ctrl.checkUserLogin(username, hash);
	    	  String firstName = ctrl.getFirstName(username);
	    	  int userID = ctrl.getUserID(username);
	    	  int userType = ctrl.getUserType(username);
	    	  
	    	  String returnTo = request.getParameter("returnTo");
		    		
	    	  if (success == 1){
	    		  session.setAttribute("name", firstName);
	    		  session.setAttribute("userID", userID);
	    		  request.setAttribute("name", firstName);
    			  request.setAttribute("userType", userType);
    			  request.setAttribute("books", displayBooks(request, response));
    			  
    			  if (returnTo != null){  
    				  BookHandlerServlet.viewMoreInfo(request, response);
    			  }else{
    				  request.getRequestDispatcher("loggedIn.jsp").forward(request, response);
    			  }
	    	  }else{
	    		  session.invalidate();
    			  request.setAttribute("books", displayBooks(request, response));
	    		  request.setAttribute("errorMsg", "Incorrect username or password");
	    		  
	    		  if (returnTo != null){
	    			  BookHandlerServlet.viewMoreInfo(request, response);
	    		  }else{
	    			  request.getRequestDispatcher("index.jsp").forward(request, response);
	    		  }
	    	  }  
	      } 
	}

//--------------------REGISTER ------------------------------------------------------------------------------------------------------------------------------- 
	public void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String hash = SecureLogin.Hash(password);
		
		HttpSession session = request.getSession(true);
		String returnTo = request.getParameter("returnTo");

	
  		DbLogicImpl ctrl = new DbLogicImpl();
		//checks to see if the username already exists in the database
  		//lets user register if not in db, otherwise gives an error message
  		int check = ctrl.checkUser(username);
  		
  		if (session.isNew()) {
	  		if (check == 0){
	  			ctrl.registerUser(firstName, lastName, username, email, password, hash);
	  			session.setAttribute("name", ctrl.getFirstName(username));
	  			request.setAttribute("name", ctrl.getFirstName(username));
	  			request.setAttribute("books", displayBooks(request, response));
	  			request.getRequestDispatcher("index.jsp").forward(request, response);
	  		}else{
	  			session.invalidate();
	  			request.setAttribute("books", displayBooks(request, response));
	  			request.setAttribute("errorMsg", "Username is already taken. Please select a new one.");
	  			request.getRequestDispatcher("index.jsp").forward(request, response);
	  		}
  		 }
	}


	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session!=null){
			session.invalidate();
		}
		request.setAttribute("books", displayBooks(request, response));
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
//--------------------DISPLAY - INITIAL LOAD------------------------------------------------------------------------------------------------------------------------------- 

	private void displayAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(firstCall);
		firstCall++;
		DbLogicImpl ctrl = new DbLogicImpl();
		ArrayList<Book> books = new ArrayList<Book>();
		books = ctrl.getAllBooks();
		
		request.setAttribute("books", books);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
	//--------------------DISPLAY - AFTER FIRST LOAD------------------------------------------------------------------------------------------------------------------------------- 

		public static ArrayList<Book> displayBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			firstCall++;
			DbLogicImpl ctrl = new DbLogicImpl();
			ArrayList<Book> books = new ArrayList<Book>();
			books = ctrl.getAllBooks();
			
			request.setAttribute("books", books);
			return books;
		}
		
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
