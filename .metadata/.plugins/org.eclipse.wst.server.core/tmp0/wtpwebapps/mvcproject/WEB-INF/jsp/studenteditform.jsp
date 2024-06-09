<!DOCTYPE html>
<html>
<head>
    <title>Edit Student</title>
</head>
<body>
    <h2>Edit Student</h2>
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
                <td>Major:</td>
                <td><input type="text" name="major" value="${command.major}" /></td>
            </tr>
            <tr>
                <td>GPA:</td>
                <td><input type="number" name="gpa" value="${command.gpa}" /></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Save" /></td>
            </tr>
        </table>
    </form>
</body>
</html>	