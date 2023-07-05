<!DOCTYPE html>
<html>
<head>
    <title>Funds</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
</head>
<body>
<h1>Funds</h1>
<table id="fundsTable">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Amount</th>
        <th>Date</th>
    </tr>
    </thead>
    <tbody></tbody>
</table>

<script type="text/javascript">
    $(document).ready(function() {
        $.ajax({
            url: '/funds/all',
            type: 'GET',
            success: function(data) {
                let tableBody = $('#fundsTable tbody');
                data.forEach(function(fund) {
                    let row = $('<tr></tr>');
                    row.append($('<td></td>').text(fund.f_id));
                    row.append($('<td></td>').text(fund.name));
                    row.append($('<td></td>').text(fund.amount));
                    row.append($('<td></td>').text(fund.dateTime));
                    tableBody.append(row);
                });
            }
        });
    });
</script>
</body>
</html>
