
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

<a href="StudentServlet">Student List</a>
<br>
<br>

<%
Student student =  (Student)request.getAttribute("s");

if(student ==null){
	 student = new Student();
	student.setStudentId(0);
	student.setStudentName("");
	student.setStudentAddress("");
	
}


%>


<h1>Student Form</h1>

<div>
	<p>
		Lorem ipsum dolor sit amet, ea quem laoreet qui. Ad invidunt molestiae referrentur has, sit paulo dicant ex.
		 Vis ad voluptua voluptatibus, ei eum augue tantas mediocritatem, ferri epicurei an usu. Pro doming adolescens
		  in, ea ius magna nobis mnesarchum, ius soluta concludaturque ut. Te nam debet elitr.
	
		Pro cu omnium appetere moderatius, ei pro discere vulputate eloquentiam, an nibh facilisi eum. 
		Nibh vivendo insolens eum te, an elitr soleat mel. Vim inani adversarium no, meis vituperatoribus ut quo, 
		sale quodsi vituperata qui at. Putent nemore at eam, quem malis nihil eu mea, no altera laboramus persequeris duo.
		 Ne pri verterem appellantur, per fierent accommodare at, unum intellegebat pro ne. Usu in tale malis soleat, vel vocent debitis democritum eu, ei probo causae civibus est. Magna postea vidisse duo an, aeque partiendo eos id.
	
		Animal rationibus at eam. Eu alia vide impedit vel. Ad eam fugit eleifend accusamus, ex sit adhuc definitionem.
		 Eu nec phaedrum erroribus contentiones.
	
		Ut corpora dignissim eos, cum copiosae verterem adolescens in. Iudico mollis cu eam. Duo fabulas suscipit detraxit ut, usu quem tale facilisis ea. Alia adipisci expetenda est cu, nec ut labore possit viderer, eum ea altera conclusionemque. Has ea omnis iriure.
	
		Nam modus rationibus ne, prima zril aperiri mea et, ut meliore inermis nec. Facete intellegam vis te, vide augue ei mei. Fabulas adipisci ei per. Te graeci epicuri has, vim nisl autem ne. Quo ne minim putent causae, est cu iudico nemore dolorem, in per recteque suavitate explicari.
	</p>
</div>

<form action="StudentServlet" method="get">
<input type="hidden" name="studentId" value="<%= student.getStudentId() %>">
Student Name : <input type="text" name="studentName" value="<%=student.getStudentName() %>">
Student Address : <input type="text" name="studentAddress" value="<%= student.getStudentAddress() %>">
<% if(student.getStudentId()==0){ %>
<input type="submit" value="Add" name="add">
<% }else{ %>
<input type="submit" value="Update" name="update">
<% } %>
</form>



</body>
</html>