
<!-- top navbar -->
<%@page import="com.amstech.userDTO.UserDTO"%>
<%
UserDTO auth = (UserDTO) session.getAttribute("auth");
UserDTO admin = (UserDTO) session.getAttribute("admin");
%>
<div class="top-navbar">
	<div class="top-icons">
		<i class="fa-brands fa-twitter"></i> <i
			class="fa-brands fa-facebook-f"></i> <i
			class="fa-brands fa-instagram"></i>
	</div>
	<form action="user" method="post">
    <input type="hidden" name="task" value="logout">
   
	<div class="other-links">
		<%
		if (auth != null ||admin!=null) {
		%>
		 
		<button id="btn-signup" value="logout" type="submit">
			Logout
		</button>
		<%
		} else {
		%>
		<button id="btn-login">
			<a href="login.jsp">Login</a>
		</button>
		<button id="btn-signup">
			<a href="signup.jsp">Sign up</a>
		</button>
		<%
		}
		%>
	

		<i class="fa-solid fa-user"></i> <i class="fa-solid fa-cart-shopping"></i>
	</div></form>
</div>
<!-- top navbar -->
<nav class="navbar navbar-expand-lg" id="navbar">
	<div class="container-fluid">
		<a class="navbar-brand" href="#"><img src="./image/logo.png"
			alt="" width="180px"></a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span><i class="fa-solid fa-bars" style="color: white;"></i></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="home.jsp">Home</a></li>

				<li class="nav-item"><a class="nav-link" href="products.jsp">Product</a>
				</li>
				
				<li class="nav-item"><a class="nav-link" href="about.jsp">About
						Us</a></li>
				<li class="nav-item"><a class="nav-link" href="contactus.jsp">Contact
						Us</a></li>
						
							<%
		if (admin != null) {
		%>
			<li class="nav-item"><a class="nav-link" href=adminHome.jsp>Admin
						</a></li>
		<%
		}else{}
		%>
						
			</ul>

			
		</div>
	</div>
</nav>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
