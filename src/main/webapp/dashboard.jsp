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
	<nav class="navbar navbar-expand-lg navbar-dark bg-info">
		<a class="navbar-brand" href="<c:url value="/" />">LeaveApproval</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><a class="nav-link" href="leave">Employee</a>
				</li>
				<li class="nav-item"><a class="nav-link"
					href="login-supervisor">Supervisor</a></li>
			</ul>
		</div>
	</nav>
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
			<div class="container">
				<table class="table table-striped">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">Applied By</th>
							<th scope="col">Applied</th>
							<th scope="col">Status</th>
							<th scope="col">Type</th>
							<th scope="col">Address</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${leaves }" var="leave">
							<tr>
								<c:set var="employee" value="${leave.employee }" />
								<th scope="row"><c:out value="${leave.id}" /></th>
								<td><c:out value="${employee.email}"></c:out></td>
								<td><c:out value="${leave.applied_on}" /></td>
								<td><c:out value="${leave.status }" /></td>
								<td><c:out value="${leave.typeOfLeave }" /></td>
								<td><c:out value="${leave.leaveAddress }"></c:out></td>
								<td><a href="#"><button class="btn btn-danger"
											type="button">Modify</button></a></td>
								<td><a href="delete-leave?id=${leave.id}"><button
											class="btn btn-danger" type="button">Delete</button></a></td>
							</tr>
						</c:forEach>

					</tbody>
				</table>
			</div>
			<div class="row">
				<div class="col">
					<hr>
				</div>
				<div class="col-auto">||</div>
				<div class="col">
					<hr>
				</div>
			</div>
			<div class="row">
				<div class="col-6">
					<p class="h4">Add Employee</p>
					<form action="add-employee">
						<div class="form-group">
							<input type="text" class="form-control" name="staff_id"
								value="${staffId }" hidden>
						</div>
						<div class="form-group">
							<label>Full Names:</label> <input type="text"
								class="form-control" name="full_name">
						</div>
						<div class="form-group">
							<label>Email:</label> <input type="text" class="form-control"
								name="email">
						</div>
						<div class="form-group">
							<label>Phone Number:</label> <input type="text"
								class="form-control" name="phone_number">
						</div>
						<div class="form-group text-center">
							<button type="submit" class="btn btn-lg btn-primary">Submit</button>
						</div>
					</form>
				</div>
				<div class="col-6">
					<p class="h4">Create New Employee LeaveRecord:</p>
					<form action="add-leave-record">
						<div class="form-group">
							<label>Employee Name:</label> <select class="form-control"
								name="employee_id">
								<c:forEach items="${employees}" var="employee">
									<option value="${employee.id}">${employee.fullNames}</option>
								</c:forEach>
							</select>
						</div>
						<div class="form-group">
							<label>Leave Days Carried Forward</label> <input type="number"
								class="form-control" min="0" max="15" name="carried_forward">
						</div>
						<div class="form-group text-center mt-5">
							<button type="submit" class="btn btn-lg btn-primary">Generate</button>
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