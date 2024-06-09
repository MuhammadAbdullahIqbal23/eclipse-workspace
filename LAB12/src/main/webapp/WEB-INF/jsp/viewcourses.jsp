<%@ page import="java.util.List" %>
<%@ page import="bean.Course" %>
<html>
<head>
    <title>View Courses</title>
</head>
<body>
    <h2>Courses List</h2>
    <table border="1">
        <tr>
            <th>Title</th>
            <th>Credits</th>
            <th>Instructor</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach var="course" items="${courses}">
            <tr>
                <td>${course.title}</td>
                <td>${course.credits}</td>
                <td>${course.instructor}</td>
                <td><a href="/courses/edit/${course.id}">Edit</a></td>
                <td><a href="/courses/delete/${course.id}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
