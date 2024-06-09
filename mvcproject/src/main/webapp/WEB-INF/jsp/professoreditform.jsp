<!DOCTYPE html>
<html>
<head>
    <title>Edit Professor</title>
</head>
<body>
    <h2>Edit Professor</h2>
    <form action="/editsave" method="post">
        <table>
            <tr>
                <td>ID:</td>
                <td><input type="text" name="id" value="${command.id}" readonly /></td>
            </tr>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="name" value="${command.name}" /></td>
            </tr>
            <tr>
                <td>Course Code:</td>
                <td><input type="text" name="courseCode" value="${command.courseCode}" /></td>
            </tr>
            <tr>
                <td>Credits:</td>
                <td><input type="number" name="credits" value="${command.credits}" /></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Save" /></td>
            </tr>
        </table>
    </form>
</body>
</html>
