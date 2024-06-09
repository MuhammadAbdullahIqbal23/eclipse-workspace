<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Students</title>
</head>
<body>
<h1>Students List</h1>
<table border="2" width="70%" cellpadding="2">
<tr>
<th>ID</th>
<th>Name</th>
<th>Major</th>
<th>GPA</th>
<th>Edit</th>
<th>Delete</th>
</tr>
<c:forEach var="s" items="${list}">
<tr>
<td>${s.id}</td>
<td>${s.name}</td>
<td>${s.major}</td>
<td>${s.gpa}</td>
<td><a href="editstudent/${s.id}">Edit</a></td>
<td><a href="deletestudent/${s.id}">Delete</a></td>
</tr>
</c:forEach>
</table>
<br/>
<a href="studentform">Add New Student</a>
</body>
</html>