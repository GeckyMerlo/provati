<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>EL syntax examples</title>
</head>
<body>

<p>This is the value of the browser page variable, initialized to the User-Agent request header:</p>
<c:set var="browser" value="${header['User-Agent']}"/>
<c:out value="${browser}"/>

<c:remove var= "browser" />
<p>This is the DEFAULT value of the browser page variable, after removing it:</p>
<c:out value="${browser}" default="No value of browser defined" />

<p>This is conditional printing based on a request parameter value:</p>

<c:set var="group" value="${param['role']}"/>
<c:choose>	
<c:when test = "${group == 'admin'}"> Administrator</c:when>
<c:when test = "${group == 'internal'}"> Internal</c:when>
<c:otherwise>Guest</c:otherwise>
</c:choose>


</body>
</html>