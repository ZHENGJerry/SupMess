<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<%-- <link href="../css/findFriend.css" rel="stylesheet" type="text/css" />--%>

<title>FindFriend</title>
<style type="text/css"> 
div#find
{
	font-weight:500;
	color:green;
	font-size:0.5cm;
	font-style:italic;
	margin-left:20px;
	margin-top:0.5cm;
}
div#add{
	
	
	margin-left:40px;
	margin-top:0.5cm;
}
div#form{
	font-weight:500;
	font-size:0.8cm;
	font-style:italic;
	margin-left:20px;
	margin-top:0cm;
}

</style>
</head>
<body style="background:url('../images/3.jpg') no-repeat;">
<center>
		<h1>
			<font color="#0000f0">
				<strong>Find a Friend</strong>
			</font>
		</h1>
</center>
	<jsp:include page="/jsp/header.jsp" />
	<div id="form">
	<form  action="${pageContext.request.contextPath }/findFriend?operation=find" method="post">
			
			Username :
			<input type="text" name="username" value="" />
			
			<input type="submit" value="find"/>
			
	</form>
	</div>
	
	<c:choose>
		<c:when test="${!empty find }">
		<div id="find">
			${find }<br>
			username:${UserInformation.username }<br />
			lastname:${UserInformation.lastname }<br />
			firstname:${UserInformation.firstname }<br />
			email:${UserInformation.email }
		</div>
			<c:if test="${empty alreadyfriend }">
				
				<form  action="${pageContext.request.contextPath }/addFriend?username=${UserInformation.username}" method="post">
					<div id="add">
					<input type="submit" value="Add Friend"/>
					</div>
				</form>
			</c:if>
		</c:when>
		<c:otherwise>
			<c:if test="${!empty notfind }">
				${notfind }
			</c:if>
			<c:if test="${empty notfind }">
				
			</c:if>
		</c:otherwise>
	</c:choose>
	
	${errorinformation }

</body>
</html>