
<%@ page import="java.util.*" %>

<%@ page import="com.stosh.model.Student" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<a href="student-form.jsp">Add Student</a>
<br>
<br>

<h1>Student List</h1>
<form action="StudentServlet" method="post">
	Search:
	Name<input type="text" name="studentName"> 
	Address:<input type="text" name="studentAddress">
	<input type="submit" value="Search" name="search">
</form>



<%

List<Student> studentList = (ArrayList)request.getAttribute("sList");
 
%>

<table>
<tr>
<td>ID</td>
<td>Name</td>
<td>Address</td>
</tr>
<% 



for(int i=0; i<studentList.size(); i++){ 
Student s = studentList.get(i);

%>

<tr>
<td><%= s.getStudentId() %></td>
<td><%= s.getStudentName() %></td>
<td><%= s.getStudentAddress() %></td>
<td><a href="StudentServlet?studentIdForEdit=<%=s.getStudentId()%>">Edit</a></td>
<td><a href="StudentServlet?studentIdForDelete=<%=s.getStudentId()%>">Delete</a></td>
</tr>

<% 

} 

%>

<!-- ***********this is for pagination *********-->
<br>
<a href="StudentServlet?p=1"> 1</a>
<a href="StudentServlet?p=2"> 2</a>
<a href="StudentServlet?p=3"> 3</a>


<!-- ************************************************* -->
</table>


</body>
</html>