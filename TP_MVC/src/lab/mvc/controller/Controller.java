package lab.mvc.controller;

import lab.mvc.model.*; //on importe le modele (le constructeur de Person)

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE = "/WEB-INF/index.html";          
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Person personneBean = new Person();
		/* Initialisation de ses propriétés */
		personneBean.setNom(request.getParameter("nom"));
		personneBean.setPrenom(request.getParameter("prenom"));
		personneBean.setDate(request.getParameter("date"));
		personneBean.setSexe(request.getParameter("sexe"));
			
		/* Stockage du message et du bean dans l'objet request */
		request.setAttribute( "personne", personneBean );
		
		String date = personneBean.getDate();
		int dateEnChiffres = Integer.parseInt(date); //on convertit la date en int
		
		/* Transmission de la paire d'objets request/response à notre JSP selon la date*/
		if (dateEnChiffres<=1900)
			this.getServletContext().getRequestDispatcher( "/WEB-INF/old.jsp" ).forward( request, response );
		
		else
			this.getServletContext().getRequestDispatcher( "/WEB-INF/young.jsp" ).forward( request, response );
	}

}
