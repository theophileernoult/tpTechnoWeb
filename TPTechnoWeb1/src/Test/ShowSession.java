package Test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/ShowSession")
public class ShowSession extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public ShowSession() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out = response.getWriter();		
		
		/* Création ou récupération de la session */
		HttpSession session = request.getSession();

		/* Mise en session d'une chaîne de caractères */
		String PremiereVisite = "Welcome";
		String PlusieursVisites = "Welcome Back";
		
		if (session.isNew()==true){
			session.setAttribute( "chaine", PremiereVisite );
			out.println("nbr de visites : 1");
		}
		else {
			session.setAttribute( "chaine", PlusieursVisites );
			
			Cookie cookie = null;
			Cookie[] cookies = null;
			// on a un tableau de tous les cookies du domaine
			cookies = request.getCookies();

			// on met la reponse en html
			response.setContentType("text/html");


			String visites = "a"; //on la concatenera plus tard pour compter le nbr de visites

			if( cookies != null ){
			  for (int i = 0; i < cookies.length; i++){
			     cookie = cookies[i];
			     visites=cookie.getValue( ); 	
			  }
			  
			  visites+="a"; //on ajoute une visite (a)
			  
			  Cookie sessionVisites=new Cookie("cookie_Visites",visites);//cookie de visites
			  sessionVisites.setValue(visites);
			  response.addCookie(sessionVisites);
			  
			  //on update dans le cookie de visites

			  out.println("nbr de visites : " + visites.length());
			  
			}
			
		}

		/* Récupération de l'objet depuis la session */
		String chaine = (String) session.getAttribute( "chaine" );
		
		out.println(chaine);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
