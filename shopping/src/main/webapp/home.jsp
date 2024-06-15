<%@page import="java.sql.Connection"%>
<%@page import="com.amstech.productDTO.ProductDTO"%>
<%@page import="java.util.List"%>
<%@page import="com.amstech.util.DBUtil"%>
<%@page import="com.amstech.productDAO.ProductDAO"%>
<%@page import="com.amstech.util.DBUtil"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<% DBUtil dbUtil=new DBUtil();
ProductDTO productDTO;
List<ProductDTO> products;
ProductDAO pd=new ProductDAO(dbUtil); 
products=pd.getAllProduct();

%>


<!DOCTYPE html>

<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Fashion</title>
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

	<!-- home content -->
	<section class="home" style="background-image: url('image/pbanner.jpg');">
		<div class="content">
			<h3>
				welcome to saree sale<br> <span>Up To 50% Off</span>
			</h3>
			<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit.
				Atque culpa, totam sed maxime animi facilis!</p>
				<button id="btn-login">
			<a href="products.jsp">Shop now</a>
		</button>
		</div>
		<div class="img">
			<!------ <img src="./image/frontpage.png" alt="">---->
			
		</div>
	</section>
	<!-- home content -->
	</div>

	<!-- top cards -->
	<div class="container" id="top-cards">
		<div class="row">
			<div class="col-md-5 py-3 py-md-0">
				<div class="card" style="background-color: #a9a9a926;">
					<img src="./image/card1.png" alt="">
					<div class="card-img-overlay">
						<h5 class="card-titel">Black saree</h5>
						<p>Lorem ipsum dolor sit amet consectetur adipisicing elit.
							Provident, ratione!</p>
						<p>
							<strong>$200.30 <strike>$250.10</strike></strong>
						</p>
						<button>Order Now</button>
					</div>
				</div>
			</div>
			<div class="col-md-4 py-3 py-md-0">
				<div class="card" style="background-color: #a9a9a926;">
					<img src="./image/card2.png" alt="">
					<div class="card-img-overlay">
						<h5 class="card-titel">Voilet saree</h5>
						<p>Lorem ipsum dolor sit amet consectetur adipisicing elit.
							Provident, ratione!</p>
						<p>
							<strong>$150.10 <strike>$200.10</strike></strong>
						</p>
						<button>Order Now</button>
					</div>
				</div>
			</div>
			<div class="col-md-3 py-3 py-md-0">
				<div class="card" style="background-color: #a9a9a926;">
					<img src="./image/card4.png" alt="">
					<div class="card-img-overlay">
						<h5 class="card-titel">Red saree</h5>
						<p>Lorem ipsum dolor sit amet consectetur adipisicing.</p>
						<p>
							<strong>$50.10 <strike>$60</strike></strong>
						</p>
						<button>Order Now</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- top cards -->


	<!-- banner -->
	<div class="banner " style="background-image: url('image/bannersaree.png');">
		<div class="content">
			<h1>Get Up To 50% Off</h1>
			<p>Lorem ipsum dolor sit amet consectetur adipisicing elit.
				Tempora, animi?</p>
			<div id="bannerbtn">
				<button>SHOP NOW</button>
			</div>
		</div>
	</div>
	<!-- banner -->


	<div class="container" id="product-cards">
		<h1 class="text-center">PRODUCT</h1>
		<div class="row" style="margin-top: 30px;">
	
		<% if(!products.isEmpty()){
			for(ProductDTO p:products){
						%>
				<div class="col-md-3 py-3 py-md-0">
				<div class="card">
					<img src="./image/<%out.print(p.getImage());%>" alt="">
					<div class="card-body">
						<h3><% out.print(p.getName()); %></h3>
						<p><%out.print(p.getCategory());  %></p>
						<div class="star">
							<i class="fas fa-star checked"></i> <i
								class="fas fa-star checked"></i> <i class="fas fa-star checked"></i>
							<i class="fas fa-star checked"></i> <i
								class="fas fa-star checked"></i>
						</div>
						<h6>
							Rs. <%=p.getPrice()%>
							 <strike>Rs. <%=p.getPrice()+300%></strike>
							 
							<form action="cart" method="post">
								<input type="hidden" name="task" value="addToCart"> 
								<input type="hidden" name="id" value="<%=p.getId()%>">
								<button id="btn-signup" type="submit"  value="addToCart">Buy</button>
							</form>
							
							
						</h6>
						
						
					</div>
				
				</div>
			</div>
	<%}
		} %>
		</div>
	</div>
	<%@include file="include/footer.jsp"%>
</body>
</html>