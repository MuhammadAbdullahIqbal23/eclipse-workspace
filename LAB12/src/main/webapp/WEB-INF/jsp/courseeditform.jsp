<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Edit Course</title>
</head>
<body>
    <h2>Edit Course Form</h2>
    <form:form method="POST" action="/courses/edit">
        <form:hidden path="id" />
        <form:input path="title" placeholder="Course Title" />
        <form:input path="credits" placeholder="Credits" />
        <form:input path="instructor" placeholder="Instructor" />
        <input type="submit" value="Save Changes" />
    </form:form>
</body>
</html>