<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>SendMessage</title>

<style type="text/css"> 
div#simpleIntr{
margin-top:2.5cm;
width:400px;
height:50px;
background:red;
position:relative;
animation-name:myfirst;
animation-duration:10s;
animation-timing-function:linear;
animation-delay:2s;
animation-iteration-count:infinite;
animation-direction:alternate;
animation-play-state:running;

}

@keyframes myfirst
{
0%   {background:red; left:100px; top:0px;}
25%  {background:yellow; left:300px; top:-100px;}
50%  {background:blue; left:600px; top:-300px;}
75%  {background:green; left:250px; top:0px;}
100% {background:red; left:700px; top:0px;}
}
div#Homepage
{
	font-weight:500;
	color:white;
	font-size:0.8cm;
	font-style:italic;
	margin-left:50px;
	margin-top:0cm;
}
div#registerUser{
	font-weight:500;
	color:white;
	font-size:0.8cm;
	font-style:italic;
	margin-left:200px;
	margin-top:-0.9cm;
}
div#form{
	font-weight:500;
	font-size:0.8cm;
	font-style:italic;
	margin-left:270px;
	margin-top:0cm;
}
div#sendBattern{
	margin-left:130px;
	margin-top:0.5cm;
	
}
</style>

</head>
<body style="background:url('../images/1.jpg') no-repeat;">
<center>
		<h1>
			<font color="#0000f0">
				<strong>Send Message To Admin</strong>
			</font>
		</h1>
</center>

	<div id="Homepage">
	<a href="${pageContext.request.contextPath }/index.jsp">Homepage</a>
	</div>
	<div id="registerUser">
	<a href="${pageContext.request.contextPath }/jsp/registerUser.jsp">Register User</a><br/>
	</div>
	<div id="form">
	<form  action="${pageContext.request.contextPath }/sendMessage?operation=anonymous" method="post">
		<div id="p1">
		<p>Send a message to Admin</p>
		</div>
		<div id="txtarea">
		<textarea rows="10" cols="40" name="message"></textarea>
		</div>
		<div id="sendBattern">
		<input type="submit"  value="send" />
		</div>
		<div id="simpleIntr">
		<p>Welcome to REGISTER!!!!!</p>
		</div>
	</form>
	</div>
	
	
</body>
</html>