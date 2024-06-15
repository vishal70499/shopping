<%@page import="java.sql.Connection"%>
<%@page import="com.amstech.productDTO.ProductDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.amstech.util.DBUtil"%>
<%@page import="com.amstech.productDAO.ProductDAO"%>
<%@page import="com.amstech.util.DBUtil"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
DBUtil dbUtil = new DBUtil();
ProductDTO productDTO;
List<ProductDTO> products;
ProductDAO pd = new ProductDAO(dbUtil);
products = pd.getAllProduct();
%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>AdminHome</title>

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

	<form action="product" method="post">
		<input type="hidden" name="task" value="addProduct">


		<!-- Welcome -->
		<div class="container login">
			<div class="row">
				<div class="col-md-4" id="side1">
					<h3>Welcome <%out.print(admin.getName()); %></h3>
					<p>admin can add products here.</p>

				</div>
				<div class="col-md-8" id="side2">
					<h3>Add product</h3>
					<div class="inp">
						<input type="text" name="name" placeholder="Name" required>
						<input type="text" name="category" placeholder="Category" required>
						<input type="number" name="price" placeholder="Price" required>
						<input type="text" name="image" placeholder="Image" required>

					</div>
					<p>you can update product here</p>
					<div class="icons">
						<i class="fa-brands fa-twitter"></i> <i
							class="fa-brands fa-facebook-f"></i> <i
							class="fa-brands fa-instagram"></i>
					</div>
					<div id="login">
						<button type="submit" value="addProduct">ADD-PRODUCT</button>
					</div>
				</div>
			</div>
		</div>
		<!-- Welcome -->

	</form>
	<div>
		<%
		String msg = request.getParameter("msg");
		if ("valid".equals(msg)) {
		%>
		<h1>successfully updated..........</h1>
		<%
		}
		%>
		<%
		if ("invalid".equals(msg)) {
		%>
		<h1>something went wrong...try again......</h1>
		<%
		}
		%>

	</div>

	<div class="container" id="product-cards">
		<h1 class="text-center">PRODUCT</h1>
		<div class="row" style="margin-top: 30px;">

			<%
			if (!products.isEmpty()) {
				for (ProductDTO p : products) {
			%>
			<div class="col-md-3 py-3 py-md-0">
				<div class="card">
					<img src="./image/<%out.print(p.getImage());%>" alt="">
					<div class="card-body">
						<h3>
							<%
							out.print(p.getName());
							%>
						</h3>
						<p>
							<%
							out.print(p.getCategory());
							%>
						</p>
						<div class="star">
							<i class="fas fa-star checked"></i> <i
								class="fas fa-star checked"></i> <i class="fas fa-star checked"></i>
							<i class="fas fa-star checked"></i> <i
								class="fas fa-star checked"></i>
						</div>
						<h5>
							Rs.
							<%
						out.print(p.getPrice());
						%>
							<strike>Rs. <%
							out.print(p.getPrice() + 0);
							%></strike>
							
						
							<form action="product" method="post">
								<input type="hidden" name="task" value="delete"> <input
									type="hidden" name="id" value="<%out.print(p.getId());%>">
								<button id="btn-signup" type="submit" value="delete">Delete</button>
							</form>
						</h5>
						<h6>
							ID:<%
						out.print(p.getId());
						%>
						</h6>
					</div>

				</div>
			</div>
			<%
			}
			}
			%>

			<%@include file="include/footer.jsp"%>
</body>
</html>