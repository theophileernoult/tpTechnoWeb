package Test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ListItem")
public class ListItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE = "/WEB-INF/ListItem.html";      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");  
	    PrintWriter out = response.getWriter();  
		
	    
	    HttpSession sessionItem = request.getSession();
	    
	    String item=request.getParameter("newItem");
	    
 		ArrayList<String> tableau=new ArrayList<String>();
   
	    if (sessionItem.isNew()!=true)
	    	tableau = new ArrayList<String>();
	    	tableau = (ArrayList<String>)sessionItem.getAttribute("tableauDesItems");
	    
	    tableau.add(item); 
	    sessionItem.setAttribute("tableauDesItems", tableau);
	    
	       for(String elem: tableau)
	       {
	       	 out.println (elem); 
	       }

	}

}
