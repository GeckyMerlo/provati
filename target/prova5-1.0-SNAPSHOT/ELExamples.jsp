<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Examples of EL expressions</title>

</head>
<body>
	<h3>HTTP request parameters</h3>
	<p>
		param.city:
		<c:out value="${param.city}" />
	</p>
	<h3>HTTP request headers</h3>
	<p>
		header['User-Agent']:
		<c:out value="${header['User-Agent']}" />
	</p>
	<h3>List of all the available Cookies</h3>
	<ul>
		<c:forEach var="cookies" items="${cookie}">
			<li><c:out value="${cookies.key}" />: Object=<c:out
					value="${cookies.value}" />, value=<c:out
					value="${cookies.value.value}" /></li>
		</c:forEach>
	</ul>
<h3>List of all init paramaters</h3>
	<ul>
		<c:forEach var="initParams" items="${initParam}">
			<li><c:out value="${initParams.key}" />: Value=<c:out
					value="${initParams.value}" />, value=</li>
		</c:forEach>
	</ul>
	<h3>Scopes: 1) direct access, access through implicit scope objects: 2) dot notation 3) map notation</h3>
	<c:set var="pageVar" scope="page" value="pageValue" />
	<c:set var="requestVar" scope="request" value="requestValue" />
	<c:set var="sessionVar" scope="session" value="sessionValue" />
	<c:set var="applicationVar" scope="application" value="applicationValue" />

	<p>
		Value of pageVar:
		1) <c:out value="${pageVar}" />, 2) <c:out value="${pageScope.pageVar}" />, 3) <c:out value="${pageScope['pageVar']}" />
	</p>

	<p>
		Value of requestVar:
		1) <c:out value="${requestVar}" />, 2) <c:out value="${requestScope.requestVar}" />, 3) <c:out value="${requestScope['requestVar']}" />, 
	</p>

	<p>
		Value of sessionVar:
		1) <c:out value="${sessionVar}" />, 2) <c:out value="${sessionScope.sessionVar}" />, 3) <c:out value="${sessionScope['sessionVar']}" />, 
	</p>

	<p>
		Value of applicationVar:
		1) <c:out value="${applicationVar}" />, 2) <c:out value="${applicationScope.applicationVar}" />, 3) <c:out value="${applicationScope['applicationVar']}" />
	</p>

</body>
</html>