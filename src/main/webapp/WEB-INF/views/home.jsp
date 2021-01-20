<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>Contact List</h1>
		<h3>
			<a href="/SpringMVCJDBC/newContact">New Contact</a>
		</h3>
		<table border="1">
			<thead>
				<tr>
					<th>No</th>
					<th>Name</th>
					<th>Email</th>
					<th>Address</th>
					<th>Telephone</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="contact" items="${listContact }" varStatus="status">
					<tr>
						<td>${status.index + 1 }</td>
						<td>${contact.name }</td>
						<td>${contact.email }</td>
						<td>${contact.address }</td>
						<td>${contact.telephone }</td>
						<td><a href="/SpringMVCJDBC/editContact?id=${contact.id }">Edit</a> <a
							href="/SpringMVCJDBC/deleteContact?id=${contact.id }">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>