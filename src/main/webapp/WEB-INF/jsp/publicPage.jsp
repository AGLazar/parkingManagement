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
        <input type="hidden" name="calculated" value='<c:out value="${calculated}"/>'/>
        Insert Code: <input type="text" name="code">

        <c:if test="${not calculated}">
            <input type="submit" value="Calculate">
        </c:if>


        <br>
        <c:out value="${price}"/> lei
        <br>

        <c:if test="${calculated}">
            <input type="submit" value="Pay">
            <c:out value="${payed}"/>
        </c:if>
        <c:if test="${not empty payedMessage}">
            <c:out value="${payedMessage}"/>
        </c:if>
    </form>
</div>

<div id="div3">
    <form action="/exit" method="post">

        <br><br><br>EXIT<br><br><br>

        Enter Code: <input type="text" name="code">
        <input type="submit" value="Exit Parking">
        <br>
        <c:out value="${validate}"/>
    </form>
</div>

<div id="div4">
    <form action="/createSubscription" method="post">
        <br><br><br>SUBSCRIPTION <br><br><br>

        Start date<input type="date" name="startDate" value='<c:out value="${startDate}"/>'/><br>
        End date<input type="date" name="endDate" value='<c:out value="${endDate}"/>'/><br>
        <input type="submit" value="Get Code"/>
        <c:if test="${not empty generatedCode}">
           Your code is <c:out value="${generatedCode}"/>
        </c:if>
    </form>

</div>

</body>
</html>