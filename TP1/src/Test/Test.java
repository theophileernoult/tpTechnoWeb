package Test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/test1")
public class Test extends HttpServlet {

	
	private static final long serialVersionUID = 1L;
	public static final String VUE = "/WEB-INF/inscription.jsp";       

    public Test() {
        super();
        // TODO Auto-generated constructor stub
    }


    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        /* Affichage de la page d'inscription */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
        
    	
    	try{  
    		  
    	    response.setContentType("text/html");  
    	    PrintWriter out = response.getWriter();  
    	          
    	    String nomUtilisateur=request.getParameter("nom");
    	    String prenomUtilisateur=request.getParameter("prenom");
    	    String dateUtilisateur=request.getParameter("date");
    	    String sexeUtilisateur=request.getParameter("sexe");
    	    String visites="a";
    	    
    	    out.print("" +nomUtilisateur +prenomUtilisateur +dateUtilisateur +sexeUtilisateur);  
    	    out.println("<br>");
    	    out.println("<br>");
    	    out.println("<a href=\"test2\">lien vers cookies</a>");
    	  
    	    Cookie cookieNom=new Cookie("cookie_Nom",nomUtilisateur);//cookie de nom
    	    Cookie cookiePrenom=new Cookie("cookie_Prenom",prenomUtilisateur);//cookie de prenom
    	    Cookie cookieDate=new Cookie("cookie_Date",dateUtilisateur);//cookie de date
    	    Cookie cookieSexe=new Cookie("cookie_Sexe",sexeUtilisateur);//cookie de sexe
    	    Cookie cookieVisites=new Cookie("cookie_Visites",visites);//cookie de visites
    	    
    	    cookieNom.setMaxAge(60*60*24);
    	    cookiePrenom.setMaxAge(60*60*24);
    	    cookieDate.setMaxAge(60*60*24);
    	    cookieSexe.setMaxAge(60*60*24);
    	    cookieVisites.setMaxAge(60*60*24);
    	    
    	    response.addCookie(cookiePrenom);
    	    response.addCookie(cookieNom);
    	    response.addCookie(cookieDate);  
    	    response.addCookie(cookieSexe);
    	    response.addCookie(cookieVisites);//et on les ajoute dans la reponse oklm

    	    out.close();  
    	  
    	        }catch(Exception e){System.out.println(e);}
    	
    	
    }

}
