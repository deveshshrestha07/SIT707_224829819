<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Question 3</title>
</head>
<body>

<h2>Q3: Multiplication</h2>

<!-- Show error message if exists -->
<div style="color:red">${message}</div><br/><br/>

<form action="/q3" method="post">
    <label for="number1">First number:</label><br>
    <input type="text" id="number1" name="number1"><br><br>

    <label for="number2">Second number:</label><br>
    <input type="text" id="number2" name="number2"><br><br>

    <label for="result">Your Answer:</label><br>
    <input type="text" id="result" name="result"><br><br>

    <input type="submit" value="Submit">
</form>

</body>
</html>
