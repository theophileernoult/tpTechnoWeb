<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>vieux</title>
</head>
<body>
          vous êtes vieux :
            <%	
	    lab.mvc.model.Person beanTransfere = (lab.mvc.model.Person) request.getAttribute("personne");
	    out.println( beanTransfere.getPrenom() );
        out.println( beanTransfere.getNom() );
        out.println( beanTransfere.getDate() );
        out.println( beanTransfere.getSexe() );
            %>
</body>
</html>