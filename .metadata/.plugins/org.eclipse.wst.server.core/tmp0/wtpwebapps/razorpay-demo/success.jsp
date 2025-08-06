<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Payment Successful</title>
</head>
<body>

	<h1>Payment Successful</h1>
	<p>Thank you for your payment!</p>
	<p id="orderId"></p>
	
	<script>
	
	const urlParams = new URLSearchParams(window.location.search);
	const orderId = urlParams.get('orderId');
	
	// Display the order ID on the page
	if(o
		rderId) {
			document.getElementById('orderId').textContext = "Order ID: "
					+ orderId;
		} else {
			document.getElementById('orderId').textContext = "No Order ID found.";
		}
	</script>



</body>
</html>