<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<html>
<title>Leave-Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
<body>

	<nav class="navbar navbar-expand-lg navbar-dark bg-info mb-4">
		<a class="navbar-brand" href="<c:url value="/" />">LeaveApproval</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
	</nav>

	<div class="container text-center">
		<c:if test="${ not empty message }">
			<div class="alert alert-warning w-75 text-center" role="alert">
				${message}</div>
		</c:if>
	</div>

	<div class=container>
		<form action="leave-form" class="w-50">
			<div class="form-group">
				<input class="form-control" name="staff_id" placeholder="Staff ID" required>
			</div>
			<div class="text-center">
				<button class="btn btn-primary" type="submit">Submit</button>
			</div>
		</form>
	</div>
	<script type="text/javascript"
		href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<script type="text/javascript"
		href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>
</body>
</html>