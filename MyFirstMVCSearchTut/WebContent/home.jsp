 <%@ page import="com.stosh.model.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
User validatedUser = (User)session.getAttribute("verifiedUser");

if(validatedUser != null){
%>
Welcome  : <%= validatedUser.getUserName() %>

<br>
<br>
<a href="logout.jsp" >Logout</a>



<h1>Home Page</h1>
<a href="student-form.jsp">Add Student</a>
<br>
<a href="StudentServlet">Student List</a>





<%}else{
	response.sendRedirect("login.jsp");
}
	%>



</body>
</html>