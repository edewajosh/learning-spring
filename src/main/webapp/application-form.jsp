<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<html>
<title>Leave-Form</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-info mb-4">
		<a class="navbar-brand" href="index">LeaveApproval</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
	</nav>
	<div class="container">
		<p class="h4">Apply Leave</p>
		<form action="add-employee">
			<div class="form-group">
				<label>Staff ID:</label>
				<p class="h5">${staffId }</p>
				<input type="text" class="form-control" name="staff_id">
			</div>
			<div class="form-group">
				<label>Full Names:</label> <input type="text" class="form-control"
					name="full_name">
			</div>
			<div class="form-group">
				<label>Phone Number:</label> <input type="text" class="form-control"
					name="phone_number">
			</div>
			<div class="form-group text-center">
				<button type="submit" class="btn btn-lg btn-primary">Submit</button>
			</div>
		</form>
	</div>
	<script type="text/javascript"
		href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<script type="text/javascript"
		href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>
</body>
</html>