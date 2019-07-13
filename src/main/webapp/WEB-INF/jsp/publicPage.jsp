<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="style.css">

    <title>publicPage</title>
</head>
<body>

<div id="div1" >
    <form action="/accesParking" method="POST">
        Get Code: <input type="text" name="generatedCode"><br>
        <input type="submit" value="Enter Parking">
    </form>
</div>

<div id="div2">
    <form action="/action_page.php" method="post">
        Sum to pay: <input type="text" name="sumToPay"><br>
        <input type="submit" value="Pay Parking">
    </form>
</div>

<div id="div3">
    <form action="/action_page.php" method="post">
        Insert Code: <input type="text" name="insertCode"><br>
        <input type="submit" value="Exit Parking">
    </form>
</div>

<div id="div4">
    <form action="/action_page.php" method="GET">
        Get Subscription: <input type="text" name="generatedSubscription"><br>
        <input type="submit" value="Subscription">
    </form>
</div>

</body>
</html>