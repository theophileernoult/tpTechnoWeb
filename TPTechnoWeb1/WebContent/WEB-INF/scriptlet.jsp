<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>date + ip</title>
</head>
<body>
<% 
out.println("date : ");
java.util.Date date = new java.util.Date();
out.println(date);

out.println("adresse ip : ");
out.println(request.getRemoteHost());
%>
</body>
</html>