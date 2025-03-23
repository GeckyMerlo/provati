<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<fmt:setLocale value="${header['Accept-Language']}" />
<fmt:setBundle basename="messages" />

<head>
<title>Example of Internationalization</title>
</head>
<body>
	<fmt:message key="label.welcome" />
</body>
</html>