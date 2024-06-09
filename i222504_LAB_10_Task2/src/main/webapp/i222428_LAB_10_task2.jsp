<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Sum of 2 numbers and calculateAverage</title>
</head>
<body>
    <h3>Sum of Two Numbers</h3>
    <% 
        int num1, num2;
        num1 = 10;
        num2 = 20;
        int sum;
        sum = num1 + num2;
    %>
    <%= 
        num1 + " + " + num2 + " = " + sum
    %>
    <br>
    <h3>
    Average Calculation
    </h3>
    <%! 
        double calculateAverage(double n1, double n2) {
            return (n1 + n2) / 2;
        } 
    %>
    <%= "Average of 10 and 20 is: " + calculateAverage(10, 20) %>
</body>
</html>
