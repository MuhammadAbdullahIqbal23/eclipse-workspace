<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Spring MVC Example</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }

        .container {
            max-width: 800px;
            margin: 50px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
        }

        p {
            text-align: center;
            margin-top: 20px;
            color: #888;
        }

        a {
            display: block;
            text-align: center;
            margin-top: 30px;
            color: #333;
            text-decoration: none;
            font-weight: bold;
            border: 1px solid #333;
            padding: 10px 20px;
            border-radius: 5px;
            transition: background-color 0.3s;
        }

        a:hover {
            background-color: #333;
            color: #fff;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Welcome to Spring MVC Example</h1>
        <p>This is a simple Spring MVC application.</p>
        <a href="i222504_G_LAB12/new">Add Course</a>
        <a href="/courses">View Courses</a>
    </div>
</body>
</html>
