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
	<nav class="navbar navbar-expand-lg navbar-dark bg-info mb-4">
		<a class="navbar-brand" href="<c:url value="/" />">LeaveApproval</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
	</nav>
	<div class="container">
		<table class="table table-striped">
			<thead>
				<tr>
					<th scope="col">Applied On</th>
					<th scope="col">Starting On</th>
					<th scope="col">Ending On</th>
					<th scope="col">Days Applied</th>
					<th scope="col">E-mail</th>
					<th scope="col">Status</th>
					<th scope="col">Type</th>
					<th scope="col">Address</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${leaves }" var="leave">
					<tr>
						<c:set var="staff" value="${leave.employee }" />
						<td><c:out value="${leave.applied_on}" /></td>
						<td><c:out value="${leave.started_on}" /></td>
						<td><c:out value="${leave.ended_on}" /></td>
						<td><c:out value="${leave.numberOfDaysApplied }" /></td>
						<td><c:out value="${leave.status }"></c:out></td>
						<td><c:out value="${leave.typeOfLeave }" /></td>
						<td><c:out value="${leave.leaveAddress }"></c:out></td>
						<td><a href="#"><button class="btn btn-danger"
									type="button">Update</button></a></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>
	<div class="row mt-3 mb-3">
		<hr/>
	</div>
	<div class="container">
		<div class="row mt-3 mb-3">
		<div class="col">
			<hr>
		</div>
		<div class="col-auto"><p class="h4">Apply Leave</p></div>
		<div class="col">
			<hr>
		</div>
	</div>
		<form action="leave-request">
			<div class="form-group">
				<input class="form-control" type="number" name="employee_id"
					value="${employee.id }" hidden>
			</div>
			<div class="form-row">
				<div class="form-group col-md-4">
					<label class="h6">Staff ID:</label> <input type="text"
						class="form-control" name="staff_id"
						value="${employee.staffIdNo }" disabled>
				</div>
				<div class="form-group col-md-4">
					<label class="h6">Full Names:</label> <input type="text"
						class="form-control" name="full_name"
						value="${employee.fullNames }" disabled>
				</div>
				<div class="form-group col-md-4">
					<label class="h6">Phone Number:</label> <input type="text"
						class="form-control" name="phone_number"
						value="${employee.phoneNumber }" disabled>
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label class="h6">Leave Address:</label> <input type="text"
						class="form-control" name="leave_address">
				</div>
				<div class="form-group col-md-6">
					<label class="h6">Email: </label> <input type="email"
						class="form-control" name="email" value="${employee.email }"
						disabled>
				</div>
			</div>
			<div class="form-group">
				<label class="h6">Type of Leave:</label> <select
					class="form-control" name="type_of_leave">
					<option value="maternity">Maternity</option>
					<option value="emergency">Emergency</option>
					<option value="annual">Annual</option>
					<option>
				</select>
			</div>
			<div class="form-row">
				<div class="form-group col-md-4">
					<label class="h6">Number of days Applying: </label> <input
						class="form-control" type="number" min="1" max="24"
						name="leave_days_applied">
				</div>

				<div class="form-group col-md-4">
					<label class="h6">Leave Begins on: </label> <input
						class="form-control" type="date" name="starts_on">
				</div>
				<div class="form-group col-md-4">
					<label class="h6">Leave Ends on: </label> <input
						class="form-control" type="date" name="ends_on">
				</div>
			</div>
			<div class="form-row">
				<div class="form-group col-md-6">
					<label class="h6">Supervisor:</label> <select class="form-control"
						name="supervisor_id">
						<c:forEach items="${supervisors }" var="supervisor">
							<option value="${supervisor.id}">${supervisor.fullNames}</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-groud col-md-6">
					<input class="form-control" type="number" value="${employee.id }"
						hidden>
				</div>
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