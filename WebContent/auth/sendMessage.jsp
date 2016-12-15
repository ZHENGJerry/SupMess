<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1" />
<title>SentMessage</title>
</head>
<body>

<%-- send message page --%>

<center>
		<h1>
			<font color="#0000f0">
				<strong>Send Message to ${requestScope.receiver }</strong>
			</font>
		</h1>
</center>

	<%-- send to another friend --%>
	<a href="${pageContext.request.contextPath }/findFriend?operation=list">Send to another</a>
	<jsp:include page="/jsp/header.jsp" />
	
	<%-- message form --%>
	<form action="${pageContext.request.contextPath }/sendMessage?operation=receiver" method="post">
		to:<input type="text" name="receiver" value="${requestScope.receiver }" readonly="readonly" /><br />
		<textarea rows="5" cols="10" name="message"></textarea> <br />
		<input type="submit" value="send" />
	</form>
	
	<%-- history part --%>
	<h1>History as Follow:</h1>
	<c:forEach items="${history }" var="h">
		${h.ts }&nbsp; ${h.sender }&nbsp; say &nbsp;to&nbsp; ${h.receiver }&nbsp;:${h.message }<br />
	</c:forEach>
	
</body>
</html>