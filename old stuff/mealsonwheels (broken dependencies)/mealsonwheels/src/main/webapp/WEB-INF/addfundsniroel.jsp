<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create Donation</title>
    <script>
        function createDonation() {
            // Get the name and amount from the input fields
            let name = document.getElementById("name").value;
            let amount = document.getElementById("amount").value;

            // Create a new XMLHttpRequest object
            let xhr = new XMLHttpRequest();

            // Open a new POST request to the /create endpoint
            xhr.open("POST", "/funds/create");

            // Set the request headers
            xhr.setRequestHeader("Content-Type", "application/json");

            // Send the request with the JSON data
            xhr.send(JSON.stringify({name: name, amount: amount}));

            // Handle the response
            xhr.onload = function() {
                if (xhr.status === 201) {
                    // Parse the JSON response
                    let response = JSON.parse(xhr.response);

                    // Display the response on the page
                    document.getElementById("response").innerHTML = JSON.stringify(response, null, 2);
                } else {
                    alert("Error: " + xhr.statusText);
                }
            };
        }
    </script>
</head>
<body>
<h1>Create Donation</h1>
<form onsubmit="event.preventDefault(); createDonation();">
    <label for="name">Name:</label><br>
    <input type="text" id="name" name="name"><br><br>
    <label for="amount">Amount:</label><br>
    <input type="text" id="amount" name="amount"><br><br>
    <input type="submit" value="Submit">
</form>
<h2>Response:</h2>
<pre id="response"></pre>
</body>
</html>
