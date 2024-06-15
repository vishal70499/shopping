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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css">
    <!-- bootstrap links -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <!-- bootstrap links -->
    <!-- fonts links -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@500&display=swap" rel="stylesheet">
    <!-- fonts links -->
</head>
<body>
<%@include file="include/navbar.jsp"%>

 <!-- banner -->
    <div class="banner2"  style="background-image: url('image/bannerbest.jpg');">
        <div class="content2">
            <h1>Get More Product</h1>
            <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Tempora, animi?</p>
            <div id="bannerbtn2"><button>SHOP NOW</button></div>
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
    <!-- product -->
    <div class="container" style="margin-top: 100px;">
    <hr>
</div>
<div class="container">
    <h3 style="font-weight: bold;">PRODUCT.</h3>
    <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Doloremque vero eius ipsam incidunt illum totam nostrum quidem sit cumque fugit. Accusamus rem praesentium labore tempore ullam porro quaerat fugiat cum ipsum, sint perferendis voluptate ad, quod reiciendis officia! In voluptate quae expedita sunt eum placeat alias soluta. Rem commodi, impedit error doloribus ratione at provident beatae, aut doloremque sunt possimus voluptas recusandae nam aliquid eos quia minus harum repellat quae eveniet laborum dolore esse voluptate sed. Voluptate ullam dolor sapiente neque labore hic nam odio qui consectetur porro minima nesciunt suscipit vitae obcaecati reiciendis itaque ipsum unde, debitis nemo soluta!</p>

    <hr>
</div>
    <!-- product -->


<!-- offer -->
    <div class="container" id="offer">
        <div class="row">
            <div class="col-md-4 py-3 py-md-0">
                <i class="fa-solid fa-cart-shopping"></i>
                <h5>Free Shipping</h5>
                <p>On order over $100</p>
            </div>
            <div class="col-md-4 py-3 py-md-0">
                <i class="fa-solid fa-truck"></i>
                <h5>Fast Delivery</h5>
                <p>World wide</p>
            </div>
            <div class="col-md-4 py-3 py-md-0">
                <i class="fa-solid fa-thumbs-up"></i>
                <h5>Big Choice</h5>
                <p>Of product</p>
            </div>
        </div>
    </div>
<!-- offer -->
<%@include file="include/footer.jsp"%>


    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</body>
</html>