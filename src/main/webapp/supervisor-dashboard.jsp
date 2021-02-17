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

	<div class="container">
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">Email</th>
					<th scope="col">Applied</th>
					<th scope="col">Starting</th>
					<th scope="col">Ending</th>
					<th scope="col">Days</th>
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
						<td><c:out value="${employee.email }"/></td>
						<td><c:out value="${leave.applied_on}" /></td>
						<td><c:out value="${leave.started_on}" /></td>
						<td><c:out value="${leave.ended_on}" /></td>
						<td><c:out value="${employee.totalLeaveDays }" /></td>
						<td><c:out value="${leave.status }"></c:out></td>
						<td><c:out value="${leave.typeOfLeave }" /></td>
						<td><c:out value="${leave.leaveAddress }"></c:out></td>
						<td><a href="approve-leave?id=${leave.id}"><button
									class="btn btn-danger" type="button">Approve</button></a></td>
						<td><a href="reject-leave?id=${leave.id}"><button
									class="btn btn-danger" type="button">Reject</button></a></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>

	<script type="text/javascript"
		href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<script type="text/javascript"
		href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>
</body>
</html>