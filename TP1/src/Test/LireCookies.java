package Test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/test2")
public class LireCookies extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public LireCookies() {
        super();
        // TODO Auto-generated constructor stub
    }


	 public void doGet(HttpServletRequest request,HttpServletResponse response)     throws ServletException, IOException{
Cookie cookie = null;
Cookie[] cookies = null;
// on a un tableau de tous les cookies du domaine
cookies = request.getCookies();

// on met la reponse en html
response.setContentType("text/html");

PrintWriter out = response.getWriter();

String chaineVisites = "a"; //on la concatenera plus tard pour compter le nbr de visites

if( cookies != null ){
  out.println("<h2>Liste des cookies et leurs valeurs</h2>");
  for (int i = 0; i < cookies.length; i++){
     cookie = cookies[i];
     chaineVisites=cookie.getValue( ); 
     out.print(i);
     out.print(") " + cookie.getName( ));
     
     if (i!=5) out.print(" -> " + chaineVisites+" <br/>"); //on affiche les cookies
     else out.print(" -> " + chaineVisites.length()+" <br/>"); //quand on arrive à la visite on compte
     														   //pour afficher le nbr de visites #malinxlelynx
     
  }
  
  chaineVisites+="a"; //on ajoute une visite (a)
  
  Cookie cookieVisites=new Cookie("cookie_Visites",chaineVisites);//cookie de visites
  cookieVisites.setValue(chaineVisites);
  response.addCookie(cookieVisites);
  
  //on uptade dans le cookie de visites
  
}else{
   out.println(
     "<h2>Aucun cookie :(</h2>");
}
out.println("</body>");
out.println("</html>");
    	}
	

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{    	
    }

}
 
	      