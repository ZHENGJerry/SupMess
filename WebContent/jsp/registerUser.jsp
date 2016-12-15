<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html >
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>RegisterAuser</title>
<style type="text/css"> 
div#rgster
{
font-weight:900;
width:250px;
height:50px;
background:red;
position:relative;
animation:myfirst 20s linear 1s infinite alternate;
}
@keyframes myfirst
{
0%   {background:red; left:0px; top:0px;}
25%  {background:blue; left:225px; top:150px;}
50%  {background:yellow; left:550px; top:300px;}
75%  {background:blue; left:775px; top:150px;}
100% {background:red; left:1100px; top:0px;}
}
div#homepage
{
	font-weight:500;
	color:white;
	font-size:0.8cm;
	font-style:italic;
	margin-left:50px;
	margin-top:2.5cm;
}
div#Login{
	font-weight:500;
	color:white;
	font-size:0.8cm;
	font-style:italic;
	margin-left:280px;
	margin-top:-0.9cm;
}
div#form{
	font-weight:500;
	font-size:0.8cm;
	font-style:italic;
	margin-left:570px;
	margin-top:-3cm;
}
div#battern{

	margin-left:670px;
	margin-top:-2cm;
}
</style>
</head>
<body style="background:url('../images/1.jpg') no-repeat;">
<body>
<div id="register">
	<center>
		<h1>
			<font color="#0000f0">
				<strong>Welcome To SupMessaging</strong>
			</font>
		</h1>
	</center>
	<div id="homepage">
	<a href="">Homepage</a>
	</div>
	<div id="Login">
	<a href="">Login</a><br/><br/><br/>
	</div>
	<div id="rgster">
	<p>Welcome to Register User!! :)</p>
	</div>
	<div id="form">
	<form  action="${pageContext.request.contextPath }/registerUser" method="post">
		<table align="left">
			<tr>
			<td>Username :</td>
			<td> <input type="text" name="username"></td>
			</tr>
			<tr>
			<td>Firstname: </td>
			<td><input type="text" name="firstname"></td>               
			</tr>
			<tr>
			<td>Lastname : </td>
			<td><input type="text" name="lastname"> </td>
			</tr>
			<tr>
			<td>  Email:</td>
			<td><input type="text" name="email"></td>
			</tr>
			<tr>
			<td>Password : </td>
			<td><input type="text" name="password"> </td>
			</tr>
			<div id="battern">
			<tr>
			<td><input type="submit" value="register"></td>
			<td></td>
			</tr>
			<tr>
			<td><input type="reset" value="reset"></td>
			<td></td>
			</tr>
			</div>
		</table>
		
	</form>
	</div>
</div>
</body>
</html>