<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<html>
<title></title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<body>
	<div class="container mt-3">
		<div class="row">
			<div class="col-md-3">
				<a href="create-user"><button type="button"
						class="btn btn-primary">Create User</button></a>
			</div>
			<div class="col-md-3">
				<a href="users"><button type="button" class="btn btn-info">View
						Users</button></a>
			</div>
			<div class="col-md-3">
				<a href="delete-users"><button type="button"
						class="btn btn-danger">Delete Users</button></a>
			</div>
			<div class="col-md-3">
				<a href="post-article"><button type="button"
						class="btn btn-success">Post Article</button></a>
			</div>
		</div>
	</div>
	<div class="container mt-2">
		<table class="table table-stripe table-bordered">
			<caption>List of Users</caption>
			<thead>
				<tr>
					<th scope="col">Name</th>
					<th scope="col">E-mail</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${users }" var="user">
					<tr>
						<td><c:out value="${user.name }"></c:out></td>
						<td><c:out value="${user.email }"></c:out></td>
						<td><a href="delete-user?id=${user.id}"><button
									class="btn btn-outline-danger" type="button">Delete</button></a></td>
						<td><a href="update-user?id=${user.id}"><button
									class="btn btn-outline-primary" type="button">Update</button></a></td>
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
