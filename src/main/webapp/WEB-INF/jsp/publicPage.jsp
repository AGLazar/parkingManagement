<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" type="text/css"
          href="${pageContext.request.contextPath}/resources/css/style.css"/>


    <title> Parking interface </title>
</head>


<body>
<div id="div1" >
    <form action="/accesParking" method="post">

        <br>
        <br><br><br>ENTER<br><br>
        Get / Enter Code: <input type="text" name="code">
        <input type="submit" value="Enter Parking">
        <c:out value="${ticketCode}"/>
        <!-- <br>

        Enter Code: <input type="text" name="generatedCode"><br>
        <input type="submit" value="Enter Parking"> -->
    </form>
</div>

<div id="div2">
    <form action="/payTicket" method="post">
        <br><br><br>PAY<br><br>
        Insert Code: <input type="text" name="code">
        <input type="submit" value="Calculate">

        <input type="submit" value="Pay">
        <br>
        <c:out value="${price}"/> lei
    </form>
</div>

<div id="div3">
    <form action="/action_page.php" method="post">

        <br><br><br>EXIT<br><br><br>

        Enter Code: <input type="text" name="insertCode">
        <input type="submit" value="Exit Parking">
    </form>
</div>

<div id="div4">
    <form action="/action_page.php" method="submit">

        <br><br><br>SUBSCRIPTION <br><br><br>
        Sub start date

        <input type="date" name="subscriptionStartDate"><br>
    </form>

    <form action="/action_page.php" method="submit">
        Sub end date

        <input type="date" name="subscriptionEndDate"><br>
    </form>

    <form action="/action_page.php" method="post">
        Your code: <input type="text" name="generatedCode">
        <input type="submit" value="Get Code">
    </form>

</div>

</body>
</html>