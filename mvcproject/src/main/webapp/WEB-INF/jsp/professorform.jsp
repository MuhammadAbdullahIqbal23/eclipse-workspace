<!DOCTYPE html>
<html>
<head>
    <title>Add Professor</title>
</head>
<body>
    <h2>Add Professor</h2>
    <form action="save" method="post">
        <table>
            <tr>
                <td>Name:</td>
                <td><input type="text" name="name" /></td>
            </tr>
            <tr>
                <td>Course Code:</td>
                <td><input type="text" name="courseCode" /></td>
            </tr>
            <tr>
                <td>Credits:</td>
                <td><input type="number" name="credits" /></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Save" /></td>
            </tr>
        </table>
    </form>
</body>
</html>
