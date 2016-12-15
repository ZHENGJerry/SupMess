<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>MSGhistroy</title>
</head>
<body>
<%-- the list of friend --%>
<center>
		<h1>
			<font color="#0000f0">
				<strong>Your frined List</strong>
			</font>
		</h1>
</center>
	<jsp:include page="/jsp/header.jsp" />
	
	<br />
	<c:forEach items="${listFriend }" var="l" >
	
		<a href="${pageContext.request.contextPath }/getHistory?name=${l.seconduser }">${l.seconduser }</a><br />
	
	</c:forEach>
	
</body>
</html>