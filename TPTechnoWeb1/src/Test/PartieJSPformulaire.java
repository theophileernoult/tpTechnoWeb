package Test;

import isep.lab1.bean.*; //on importe le bean

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PartieJSPformulaire")
public class PartieJSPformulaire extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String VUE = "/WEB-INF/form-jsp.jsp";       

       
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
			
		/* Transmission de la paire d'objets request/response à notre JSP */
		this.getServletContext().getRequestDispatcher( "/WEB-INF/bean.jsp" ).forward( request, response );
	}

}
