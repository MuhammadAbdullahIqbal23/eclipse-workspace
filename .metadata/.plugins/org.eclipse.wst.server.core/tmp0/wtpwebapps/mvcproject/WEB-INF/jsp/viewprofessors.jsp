<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Professors</title>
</head>
<body>
<h1>Professors List</h1>
<table border="2" width="70%" cellpadding="2">
<tr>
<th>ID</th>
<th>Name</th>
<th>Course Code</th>
<th>Credits</th>
<th>Edit</th>
<th>Delete</th>
</tr>
<c:forEach var="p" items="${list}">
<tr>
<td>${p.id}</td>
<td>${p.name}</td>
<td>${p.courseCode}</td>
<td>${p.credits}</td>
<td><a href="editprofessor/${p.id}">Edit</a></td>
<td><a href="deleteprofessor/${p.id}">Delete</a></td>
</tr>
</c:forEach>
</table>
<br/>
<a href="professorform">Add New Professor</a>
</body>
</html>