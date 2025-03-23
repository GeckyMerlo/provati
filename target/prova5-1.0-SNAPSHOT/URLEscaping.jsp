<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Example of character escaping with c:url</title>
</head>
<body>

<c:url value="/ELExamples.jsp" var="regURL">
  <c:param name="city" value="New York"/>
</c:url>
<a href="${regURL}"> Escaped URL is ${regURL}</a>

</body>
</html>