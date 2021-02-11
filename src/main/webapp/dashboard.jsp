<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin-Dashboard</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
</head>
<body>
	<div class="container mt-1 text-center ">
		<p class="h4">Admin-Dashboard</p>
	</div>
	<div class="row container-fluid mt-2">
		<div class="col-2">
			<div class="list-group">
				<a href="#" class="list-group-item list-group-item-action"> Add
					Employee </a> <a href="#"
					class="list-group-item list-group-item-action">Add Supervisor</a> <a
					href="#" class="list-group-item list-group-item-action">Leave
					Requests</a> <a href="#" class="list-group-item list-group-item-action">Staff(s)</a>
				<a href="#" class="list-group-item list-group-item-action disabled">Logout</a>
			</div>
		</div>
		<div class="col-10">
			<div class="row">
				<div class="col-6">
					<p class="h4">Add Employee</p>
					<form actio="add-employee">
						<div class="form-group">
							<label for="exampleFormControlInput1">Staff ID:</label> <input
								type="text" class="form-control" value="${staffId }" disabled>
						</div>
						<div class="form-group">
							<label for="exampleFormControlInput1">Full Names:</label> <input
								type="text" class="form-control" id="exampleFormControlInput1">
						</div>
						<div class="form-group">
							<label for="exampleFormControlInput1">Phone Number:</label> <input
								type="text" class="form-control" id="exampleFormControlInput1">
						</div>
						<div class="form-group text-center">
							<button type="submit" class="btn btn-lg btn-primary">Submit</button>
						</div>
					</form>
				</div>
				<div class="col-6">
					<p class="h4">Create Leave Record</p>
					<form action="add-leave-record">
						<div class="form-group">
							<label for="exampleFormControlInput1">Staff ID:</label> <input
								type="text" class="form-control" value="${staffId }" disabled>
						</div>
						<div class="form-group">
							<label for="exampleFormControlInput1">Leave Days
								Currently:</label> <input type="number" class="form-control" min="0"
								max="24" value="leaveDays">
						</div>
						<div class="form-group">
							<label for="exampleFormControlInput1">Leave Days Carried
								Forward:</label> <input type="number" class="form-control"
								value="carriedForward" disabled>
						</div>
						<div class="form-group">
							<label for="exampleFormControlInput1">Leave Days
								Remaining:</label> <input type="number" class="form-control"
								value="carriedForward" disabled>
						</div>
						<div class="form-group">
							<label for="exampleFormControlInput1">Total Leave Days: </label> <input type="number" class="form-control"
								value="carriedForward" disabled>
						</div>
						<div class="form-group text-center">
							<button type="submit" class="btn btn-lg btn-primary">Submit</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript"
		href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<script type="text/javascript"
		href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>
</body>
</html>