<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>SupMessagingLogin</title>

</head>
<body style="background:url('../images/1.jpg') no-repeat;">

	<center>
		<h1>
			<font color="#0000f0">
				<strong>Welcome To SupMessaging</strong>
			</font>
		</h1>
	</center>
	
	<a href="${pageContext.request.contextPath }/index.jsp">Logout</a>
	<a href="${pageContext.request.contextPath }/jsp/registerUser.jsp">Register</a><br/>
	<form  action="${pageContext.request.contextPath }/login" method="post">
		<table align="left">
			<tr>
			<td>Username :</td>
			<td> <input type="text" name="username" value="${ usernamebefore}" /></td>
			</tr>
			<tr>
			<td>Password : </td>
			<td><input type="text" name="password" /> </td>
			</tr>
			<tr>
			<td><input type="submit" value="login" /></td>
			<td></td>
			</tr>
		</table>
		
	</form>
	
	<c:choose>
		<c:when test="${!empty passwordwrong }">
				<span style="color:green;">${passwordwrong }</span>
		</c:when>
		<c:otherwise>
			<span style="color:green;">${nousererror }</span>
		</c:otherwise>
	</c:choose>
	
</body>
</html>