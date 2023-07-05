<html>
<head>
    <title>Distance Matrix</title>
</head>
<body>
<form id="distance-form">
    <input type="text" id="origin" name="origin" placeholder="Distance From">
    <input type="text" id="destination" name="destination" placeholder="Distance To">
    <input type="submit" value="Submit">
</form>

<div id="loading-icon" style="display: none;">Loading...</div>

<div id="distance-results"></div>

<script>
    document.getElementById("distance-form").addEventListener("submit", function(event) {
        event.preventDefault();

        // Show the loading icon
        document.getElementById("loading-icon").style.display = "block";

        var origin = encodeURIComponent(document.getElementById("origin").value);
        var destination = encodeURIComponent(document.getElementById("destination").value);

        var xhr = new XMLHttpRequest();
        xhr.open("POST", "/distance/" + origin + "/" + destination, true);
        xhr.onreadystatechange = function() {
            if (xhr.readyState === XMLHttpRequest.DONE && xhr.status === 200) {
                // Hide the loading icon
                document.getElementById("loading-icon").style.display = "none";

                var response = JSON.parse(xhr.responseText);
                displayDistance(response);
            } else if (xhr.readyState === XMLHttpRequest.DONE) {
                // Hide the loading icon
                document.getElementById("loading-icon").style.display = "none";

                alert("Error retrieving distance.");
            }
        };
        xhr.send();
    });

    function displayDistance(response) {
        var distanceResults = document.getElementById("distance-results");
        distanceResults.innerHTML = "";

        var distanceFrom = document.createElement("div");
        distanceFrom.textContent = "Distance From: " + response.From;
        distanceResults.appendChild(distanceFrom);

        var distanceTo = document.createElement("div");
        distanceTo.textContent = "Distance To: " + response.To;
        distanceResults.appendChild(distanceTo);

        var kilometerDistance = document.createElement("div");
        kilometerDistance.textContent = "Distance in Kilometers: " + response.Distance;
        distanceResults.appendChild(kilometerDistance);

        var timeOfArrival = document.createElement("div");
        timeOfArrival.textContent = "Time of Arrival: " + response.Duration;
        distanceResults.appendChild(timeOfArrival);

        var foodStatus = document.createElement("div");
        foodStatus.textContent = "Food Status: " + response.Status;
        distanceResults.appendChild(foodStatus);
    }
</script>

</body>
</html>
