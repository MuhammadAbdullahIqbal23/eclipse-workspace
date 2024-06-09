<!DOCTYPE html>
<html>
<head>
    <title>Add Student</title>
</head>
<body>
    <h2>Add Student</h2>
    <form action="save" method="post">
        <table>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="name" /></td>
            </tr>
            <tr>
                <td>Major:</td>
                <td><input type="text" name="major" /></td>
            </tr>
            <tr>
                <td>GPA:</td>
                <td><input type="number" name="gpa" /></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Save" /></td>
            </tr>
        </table>
    </form>
</body>
</html>