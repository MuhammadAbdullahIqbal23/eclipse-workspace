<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Edit Course</title>
</head>
<body>
    <h2>Edit Course</h2>
    <form:form method="POST" action="/courses/update">
        <form:hidden path="id" />
        <div>
            <label for="title">Title:</label>
            <form:input path="title" id="title" />
        </div>
        <div>
            <label for="credits">Credits:</label>
            <form:input path="credits" id="credits" />
        </div>
        <div>
            <label for="instructor">Instructor:</label>
            <form:input path="instructor" id="instructor" />
        </div>
        <input type="submit" value="Save Changes" />
    </form:form>
</body>
</html>
