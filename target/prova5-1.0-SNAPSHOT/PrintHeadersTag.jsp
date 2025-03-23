<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>HTTP Header Request Example</h2>
	<table width="100%" border="1" align="center">
		<tr bgcolor="#949494">
			<th>Header Name</th>
			<th>Header Value(s)</th>
		</tr>
		<jsp:scriptlet>
			java.util.Enumeration headerNames = request.getHeaderNames();
			while (headerNames.hasMoreElements()) {
				String paramName = (String) headerNames.nextElement();
				String paramValue = request.getHeader(paramName); </jsp:scriptlet>
				<tr><td> <jsp:scriptlet>out.println(paramName); </jsp:scriptlet></td> 
				<td> <jsp:scriptlet> out.println(paramValue); </jsp:scriptlet> </td></tr> 
			<jsp:scriptlet> }</jsp:scriptlet> 
	</table>
</body>
</html>