package Ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ajax")
public class Ajax extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE = "/index.html";
	
	static int verifierConnexion(String pseudo, String mdp){
		if ( pseudo.equals("abc") && (mdp.equals("123")))
			return 1;
		else
			return 0;
	}
	//fonction SANS AJAX, juste pour vérifier

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*try{  
  		  
    	    response.setContentType("text/html");  
    	    PrintWriter out = response.getWriter();
    	    
    	    
       	    String login=request.getParameter("login");
    	    String pass=request.getParameter("pass");
    	   
    	    
    	    if (verifierConnexion(login,pass)==1)
    	    	out.println("ok");
    	    else
    	    	out.println("ko");
    	    //appel de la fonction SANS AJAX, vérification
    	    
    	    
    	}catch(Exception e){System.out.println(e);}
		
		*/
			response.setContentType("text/html;charset=UTF-8");
		    PrintWriter out = response.getWriter();
		    try {
		        String user = request.getParameter("user");
		        String password = request.getParameter("password");

		        System.out.println("---->" + user);
		        System.out.println("---->" + password);

	    	    if (verifierConnexion(user,password)==1)
	    	    	out.println("ok");
	    	    else
	    	    	out.println("ko");

		    } catch (Exception e) {

		        e.printStackTrace();
		    }
	}

}
