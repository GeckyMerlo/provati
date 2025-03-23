<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="CSS/mystyle.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of people</title>
</head>
<body>
	<p>
		Number of persons that match the query:
		<c:out value="${number}" />
	</p>
	<c:choose>
		<c:when test="${number>0}">
			<table border="1">
				<tr>
					<td>Firstname</td>
					<td>Lastname</td>
					<td>City</td>
				</tr>
				<c:forEach var="person" items="${persons}" varStatus="row">
					<c:choose>
						<c:when test="${row.count % 2 == 0}">
							<tr class="even">
						</c:when>
						<c:otherwise> <tr> </c:otherwise> 
					</c:choose>
					<td><c:out value="${person.firstname}" /></td>
					<td><c:out value="${person.lastname}" /></td>
					<td><c:out value="${person.city}" /></td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>No persons match the search.
		</c:otherwise>
	</c:choose>

</body>
</html>