<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head> <meta charset="UTF-8">
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
<body> <%@include file="include/navbar.jsp" %>
	<form action="user" method="post">
		<input type="hidden" name="task" value="login">
		
        <!-- login -->
        <div class="container login">
            <div class="row">
                <div class="col-md-4" id="side1">
                    <h3>Hello Friend!</h3>
                    <p>Create New Account</p>
                    <div id="btn"><a href="signup.jsp">Sign up</a></div>
                </div>
                <div class="col-md-8" id="side2">
                    <h3>Login Account</h3>
                    <div class="inp">
                        <input type="number" name="mobileNumber"
						placeholder="enter mobile number" required>
                        <input type="password" name="password"
						placeholder="enter password" required>
                    </div>
                    <p>Forgot Your Password</p>
                    <div class="icons">
                        <i class="fa-brands fa-twitter"></i>
                        <i class="fa-brands fa-facebook-f"></i>
                        <i class="fa-brands fa-instagram"></i>
                    </div>
                    <div id="login"><button type="submit"
                      value="login">LOG IN</button></div>
                </div>
            </div>
        </div>
        <!-- login -->

		
				<%
				String msg = request.getParameter("msg");
				if ("notexist".equals(msg)) {
				%>
				<h2>incorrect username or password</h2>
				<%
				}
				%>
				<%
				if ("invalid".equals(msg)) {
				%>
				<h2>something went wrong try again!!!!!!</h2>
				<%
				}
				%>

			</div>

		</div>
		  <%@include file="include/footer.jsp" %>
</body>
</html>