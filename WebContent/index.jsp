<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<link rel="stylesheet" type="text/css" href="css/index.css" />
<title>SupMessaging</title>
</head>
<body style="background:url('images/1.jpg') no-repeat;">
<div id="body">
	<center>
		<h1>
			<font color="#0000f0">
				<strong>Welcome To SupMessaging</strong>
			</font>
		</h1>
	</center>
	<div id="link">
	<c:choose>
		<c:when test="${empty sessionScope.username }">
		<div id="register">
			<a href="${pageContext.request.contextPath }/jsp/registerUser.jsp">Register</a>
		</div>
		<div id="login">	
			<a href="${pageContext.request.contextPath }/jsp/login.jsp">Login</a>
		</div>
		<div id="connectAdmin">	
			<a href="${pageContext.request.contextPath }/jsp/connectToAdmin.jsp">ConnectAdmin</a>
		</div>
		
		</c:when>
		<c:otherwise>
		<div id="hello">
			Hello,${sessionScope.username }
		</div>
			<jsp:include page="/jsp/header.jsp" />
		
		</c:otherwise>
	
	</c:choose>
	<br/>
	

	<div id="simpleIntro">
	<p>
	You know SupMessaging?! <br/>
	SupMessaging is a good webapp to send text message . <br/>
	You can find friend in it and add him or her into you content list .<br/>
	You can change your infomation .
	You can send message . <br/>
	... <br/>
	BUT <br/>
	You must register a count before do these .<br/>
	WELCOME!!!!<br/>
	WELCOME TO GO HOME!!
	<br/>
	</p>
	</div>

<center>
	<jsp:include page="/jsp/footer.jsp" />
</center>
<div id="history">
	<c:if test="${!empty sessionScope.username }">
		
		<c:forEach items="${historylist }" var="h">
			${h.ts }&nbsp;${h.sender } <br />${h.message }<br /><br />
		</c:forEach>
	</c:if>
</div>
</body>
</html>