<%@page import="com.amstech.util.DBUtil"%>
<%@page import="com.amstech.productDAO.ProductDAO"%>
<%@page import="com.amstech.cartDTO.CartDTO"%>


<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>cart</title>
<link rel="shortcut icon" type="image" href="./image/logo2.png">
<link rel="stylesheet" href="./style/style.css">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">
<!-- bootstrap links -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<!-- bootstrap links -->
<!-- fonts links -->
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@500&display=swap"
	rel="stylesheet">
<!-- fonts links -->
</head>
<body>
	<%@include file="include/navbar.jsp"%>
	<%
	CartDTO item = (CartDTO) session.getAttribute("item");
	%>
	<div class="container" id="cart">

		<div class="d-flex py-3">
			<%
				if (item != null) {
				%>
			<h3>Total Price: <%=item.getPrice()%></h3><%
				}
				%>
			<form action="ordernow" method="post">
				<input type="hidden" name="task" value="order">
				<%
				if (auth != null) {
				%>
				<input type="hidden" name="userid" value="<%=auth.getId()%>">
				
				<input type="hidden" name="productid" value="<%=item.getId()%>">
				
				<div id="login">
					<button type="submit" value="order">Check Out</button>
				</div><%
				} else {
				%>
			<div id="login">
					<button>Check Out</button>
				</div>
				<%
				}
				%>
			</form>
		</div>
		<table class="table table-light">
			<thead>
				<tr>
					<th scope="col">Name</th>
					<th scope="col">Category</th>
					<th scope="col">Price</th>
					
					<th scope="col">Cancel</th>
				</tr>
			</thead>
			<tbody>
				<%
				if (item != null) {
				%>


				<tr>
					<td><%=item.getName()%></td>
					<td><%=item.getCategory()%></td>
					<td>Rs<%=item.getPrice()%></td>
					
					<form action="cart" method="post">
						<input type="hidden" name="task" value="removecart">


						<td><button id="btn-signup" value="removecart" type="submit">
								Remove</button></td>
				</tr>
				<%
				}
				%>

			</tbody>
			</div>

		</table>
	</div>
	<%@include file="include/footer.jsp"%>
</body>
</html>