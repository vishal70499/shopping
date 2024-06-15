<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>

<link rel="shortcut icon" type="image" href="./images/image/logo2.png">
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
<body><%@include file="include/navbar.jsp"%>
	 <form action="user" method="post">
    <input type="hidden" name="task" value="signup">
   

        <!-- login -->
        <div class="container login">
            <div class="row">
                <div class="col-md-4" id="side1">
                    <h3>Welcome Back!!</h3>
                    <p>Lorem ipsum dolor sit amet consectetur.</p>
                    <div id="btn"><a href="login.html">Login</a></div>
                </div>
                <div class="col-md-8" id="side2">
                    <h3>Create Account</h3>
                    <div class="inp">
                        <input type="text" name="name" placeholder="Name" required>
                        <input type="email" name="email" placeholder="Email" required>
                        <input type="number" name="mobileNumber" placeholder="mobileNumber" required>
                        <input type="text" name="password" placeholder="Password" required>
                        <input type="text" name="address" placeholder="Address" required>
                        <input type="text" name="city" placeholder="city" required>
                        <input type="state" name="state" placeholder="state" required>
                        <input type="text" name="country" placeholder="country" required>

                          </div>
                    <p>Create your account....</p>
                    <div class="icons">
                        <i class="fa-brands fa-twitter"></i>
                        <i class="fa-brands fa-facebook-f"></i>
                        <i class="fa-brands fa-instagram"></i>
                    </div>
                    <div id="login"><button type="submit" value="signup">SIGN UP</button></div>
                </div>
            </div>
        </div>
        <!-- login -->

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
	<%@include file="include/footer.jsp"%>
</body>
</html>