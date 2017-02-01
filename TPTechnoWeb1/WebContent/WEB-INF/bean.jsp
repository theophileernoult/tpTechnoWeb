<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Test</title>
    </head>
    <body>
            bean :
            <%	
	    isep.lab1.bean.Person beanTransfere = (isep.lab1.bean.Person) request.getAttribute("personne");
	    out.println( beanTransfere.getPrenom() );
        out.println( beanTransfere.getNom() );
        out.println( beanTransfere.getDate() );
        out.println( beanTransfere.getSexe() );
            %>
    </body>
</html>