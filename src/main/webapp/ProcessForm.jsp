<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Form input in JSP</title>
</head>
<body>
<jsp:useBean id="employee" class="it.polimi.tiw.beans.EmployeeBean">
    <jsp:setProperty name="employee" property="*"/>
</jsp:useBean>
<p>The form input is:</p>
    <p><jsp:getProperty name="employee" property="name"/></p>
    <p><jsp:getProperty name="employee" property="jobTitle"/></p>
    <p><jsp:getProperty name="employee" property="city"/></p>
</body>
</html>