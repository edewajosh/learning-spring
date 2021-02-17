<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login-Supervisor</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
<link rel="stylesheet" href="/resources/css/supervisor.css">
</head>
<body class="text-center">
	<div class="container text-center mt-2 text-center w-75">
				<c:if test="${ not empty message }">
					<div class="alert alert-warning w-75 text-center" role="alert">
						${message}</div>
				</c:if>
			</div>
	<div class="shadow container w-50 mt-4 bg-secondary text-white rounded">
		<form class="form-signin" action="supervisor-login">
			<!-- <img class="mb-4 mt-2"
				src="https://upload.wikimedia.org/wikipedia/commons/thumb/f/f6/LA_Dodgers.svg/502px-LA_Dodgers.svg.png"
				alt="" width="100" height="100"> -->
			<h1 class="h3 mb-3 font-weight-normal">Log In</h1>
			<div class="form-group">
				<label class="sr-only">Email address</label> <input type="email"
					name="email" class="form-control" placeholder="Email address"
					required autofocus>
			</div>
			<div class="form-group">
				<label class="sr-only">Password</label> <input type="password"
					name="password" class="form-control" placeholder="Password"
					required>
			</div>
			<div class="checkbox mb-3">
				<label> <input type="checkbox" value="remember-me">
					Remember me
				</label>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
				in</button>
			<p class="h6 mt-3">
				<a href="<c:url value="/" />" class="text-white">Return Home</a>
			</p>
			<p class="mt-3 mb-3">&copy; ${year}</p>
		</form>
	</div>
	<script type="text/javascript"
		href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<script type="text/javascript"
		href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>
</body>
</html>