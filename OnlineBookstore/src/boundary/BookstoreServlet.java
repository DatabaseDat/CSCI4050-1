//
package boundary;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import logic.DbLogicImpl;

/**
 * Servlet implementation class BookstoreServlet
 */
@WebServlet("/BookstoreServlet")
public class BookstoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String templateDir = "/WEB-INF/templates";
	private static String sessionID = null;
	
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
		    		
	    	  if (success == 1){
	    		  session.setAttribute("name", ctrl.getFirstName(username));
	    		  request.setAttribute("name", ctrl.getFirstName(username));
	    		  request.getRequestDispatcher("index.jsp").forward(request, response);
	    	  }else{
	    		  session.invalidate();
	    		  request.setAttribute("errorMsg", "Incorrect username or password");
	    		  request.getRequestDispatcher("index.jsp").forward(request, response);
	    	  }  
	      } else {
	    	  request.setAttribute("name", session.getAttribute("name"));
	    	  request.setAttribute("errorMsg", "Please log out in order to log in as a new user.");
    		  request.getRequestDispatcher("index.jsp").forward(request, response);
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
	
  		DbLogicImpl ctrl = new DbLogicImpl();
		//checks to see if the username already exists in the database
  		//lets user register if not in db, otherwise gives an error message
  		int check = ctrl.checkUser(username);
  		
  		if (session.isNew()) {
	  		if (check == 0){
	  			System.out.println("register success");
	  			ctrl.registerUser(firstName, lastName, username, email, password, hash);
	  		  session.setAttribute("name", ctrl.getFirstName(username));
	  			request.setAttribute("name", ctrl.getFirstName(username));
				request.getRequestDispatcher("index.jsp").forward(request, response);
	  			
	  		}else{
	  			session.invalidate();
	  			request.setAttribute("errorMsg", "Username is already taken. Please select a new one.");
	  			request.getRequestDispatcher("index.jsp").forward(request, response);
	  		}
  		 } else {
	    	  request.setAttribute("name", session.getAttribute("name"));
	    	  request.setAttribute("errorMsg", "Please log out in order to register as a new user.");
   		  request.getRequestDispatcher("index.jsp").forward(request, response);
	      }
	}

//--------------------LOGOUT ------------------------------------------------------------------------------------------------------------------------------- 

	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session!=null){
			session.invalidate();
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
