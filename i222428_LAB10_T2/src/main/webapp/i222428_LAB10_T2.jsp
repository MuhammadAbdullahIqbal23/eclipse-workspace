<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="UTF-8">
        <title>Calculate Sum and Average</title>
    </head>

    <body>
        <h1>Calculate Sum and Average</h1>

        <% int num1=10; int num2=20; int sum=num1 + num2; %>

            <h2>Sum of 10+20 = <%= sum %>
            </h2>

            <%! public int calculateAverage(int num1, int num2) { return (num1 + num2) / 2; } %>

                <h2>Average of values 10 and 20 is: <%= calculateAverage(num1, num2) %>
                </h2>
    </body>

    </html>