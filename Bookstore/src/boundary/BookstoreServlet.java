package boundary;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapperBuilder;
import freemarker.template.SimpleHash;
import logic.DbLogicImpl;
import object.RegisteredUser;



/**
 * Servlet implementation class BookstoreServlet
 */
@WebServlet("/BookstoreServlet")
public class BookstoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String templateDir = "/WEB-INF/templates";
	private TemplateProcessor processor;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookstoreServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init(ServletConfig config) throws ServletException {
		super.init(config);
		processor = new TemplateProcessor(templateDir, getServletContext());
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String register = request.getParameter("register");
		if (login != null) {
			login (request, response);
		}else if (register != null){
			register (request, response);
		}
	}

//--------------------LOGIN --------------------------------------------------------------------------------------------------------------------------------- 
	public void login(HttpServletRequest request, HttpServletResponse response){
		DefaultObjectWrapperBuilder db = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
		SimpleHash root = new SimpleHash(db.build());

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		String hash = SecureLogin.Hash(password);
		
		DbLogicImpl ctrl = new DbLogicImpl();
    	//success = 1 means the user was found with matching password and is allowed to log in
    	//success = 0 means incorrect login or password
  		int success = ctrl.checkUserLogin(username, hash);
  		
		if (success == 1){
			System.out.println("login success");
  		}else{
  			System.out.println("login failed");
  		}
	}

//--------------------REGISTER ------------------------------------------------------------------------------------------------------------------------------- 
	public void register(HttpServletRequest request, HttpServletResponse response){
		DefaultObjectWrapperBuilder db = new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_25);
		SimpleHash root = new SimpleHash(db.build());
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String hash = SecureLogin.Hash(password);
		System.out.println(firstName);
		System.out.println(lastName);
		System.out.println(username);
		System.out.println(password);
		System.out.println(hash);
		
  		DbLogicImpl ctrl = new DbLogicImpl();
		//checks to see if the username already exists in the database
  		//lets user register if not in db, otherwise gives an error message
  		int check = ctrl.checkUser(username);
  		
  		if (check == 0){
  			ctrl.registerUser(firstName, lastName, username, password, hash);
  			System.out.println("success register");
  			
  		}else{
  			System.out.println("denied register");
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
