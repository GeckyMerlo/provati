<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>A simple JSP page</title>
</head>
<body>
	<%-- This example uses a JSP expression --%>
	<p>
		Today's date:
		<%= java.text.DateFormat.getDateInstance().format(new java.util.Date()) %>
	</p>
</body>
</html>

