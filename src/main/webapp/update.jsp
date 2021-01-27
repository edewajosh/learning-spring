<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update User</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.23/css/jquery.dataTables.min.css">
</head>
<body>
	<div class="container mt-2">
		<a href="employees"><button type="button" class="btn btn-info">Home</button></a>
		<br> <br>
		<form action="update" method="post">
			<div class="form-group">
				<label for="name">Name</label> <input type="text"
					class="form-control" id="name" value="${user.name }" name="name">
			</div>
			<div class="form-group">
				<label for="email">E-mail</label> <input type="email"
					class="form-control" id="email" value="${user.email }" name="email">
			</div>
			<div class="form-group">
				<input type="hidden" class="form-control" value="${user.id }"
					name="id">
			</div>
			<button type="submit" class="btn btn-outline-success">Submit</button>
		</form>
	</div>
	<script type="text/javascript"
		href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<script type="text/javascript"
		href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>
	<script type="text/javascript"
		href="https://cdn.datatables.net/1.10.23/js/jquery.dataTables.min.js"></script>
</body>
</html>