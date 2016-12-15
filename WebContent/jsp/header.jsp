<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% boolean isConnected = false;
	if(request.getSession().getAttribute("username")!= null)
		isConnected = true;
%>
<html>
<style type="text/css"> 
div#simpleIntro
{
width:500px;
height:200px;
background:red;
position:relative;
animation:myfirst 20s linear 1s infinite alternate;
}
@keyframes myfirst
{
0%   {background:red; left:0px; top:0px;}
25%  {background:blue; left:425px; top:0px;}
50%  {background:yellow; left:850px; top:0px;}
75%  {background:blue; left:425px; top:0px;}
100% {background:red; left:0px; top:0px;}
}
div#homepage
{
	font-weight:900;
	color:white;
	font-size:0.5cm;
	font-style:italic;
	margin-left:20px;
	margin-top:1.5cm;
}
div#register{
	font-weight:900;
	color:white;
	font-size:0.5cm;
	font-style:italic;
	margin-left:150px;
	margin-top:-0.5cm;
}
div#FriendList{
	font-weight:900;
	color:white;
	font-size:0.5cm;
	font-style:italic;
	margin-left:270px;
	margin-top:-0.5cm;
}
div#FindFriend{
	font-weight:900;
	color:white;
	font-size:0.5cm;
	font-style:italic;
	margin-left:410px;
	margin-top:-0.6cm;
}
div#YourInfo{
	font-weight:900;
	color:white;
	font-size:0.5cm;
	font-style:italic;
	margin-left:550px;
	margin-top:-0.6cm;
}
div#Logout{
	font-weight:900;
	color:white;
	font-size:0.5cm;
	font-style:italic;
	margin-left:770px;
	margin-top:-0.6cm;
}

</style>
<body style="background:url('images/3.jpg') no-repeat;">
	<div id="homepage">
		<a href="${pageContext.request.contextPath }/index.jsp">Homepage</a>
	</div>
	<div id="register">
		<a href="${pageContext.request.contextPath }/jsp/registerUser.jsp">Register</a>
	</div>
	<div id="FriendList">
		<a href="${pageContext.request.contextPath }/findFriend?operation=list">Friend List</a>
	</div>
	<div id="FindFriend">
		<a href="${pageContext.request.contextPath }/jsp/findFriend.jsp">Find Friend</a>
	</div>
	<div id="YourInfo">
		<a href="${pageContext.request.contextPath }/information?operation=show">Your Information</a>
	</div>
	<div id="Logout">
		<a href="${pageContext.request.contextPath }/logout">Logout</a><br/>
	</div>
<br/>

<%
   Date date = new Date();
   out.print("&nbsp;&nbsp;&nbsp;"+date.toString());
%>

</dix>
</body>
</html>