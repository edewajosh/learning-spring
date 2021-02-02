<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
	<div class="container mt-3">
		<form action="save-article">
			<div class="form-group">
				<label>Title:</label> <input class="form-control" type="text"
					name="title">
			</div>
			<div class="form-group">
				<label>Body:</label> <input class="form-control" type="text"
					name="body">
			</div>
			<div class="form-group">
				<label>Author:</label> <input class="form-control"
					type="text" name="author_id">
			</div>
			<button type="submit" class="btn btn-outline-primary">Submit</button>
		</form>
	</div>
	<script type="text/javascript"
		href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
	<script type="text/javascript"
		href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.bundle.min.js"></script>
</body>
</html>