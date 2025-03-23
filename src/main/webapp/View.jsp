<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP page printing the request parameter</title>
</head>
<body>
 <p>The new value of the request parameter foo is: <%=request.getParameter("foo") %></p>
  <p>The original value of the request parameter foo is: <%=request.getParameter("oldfoo") %></p>
 
 
</body>
</html>