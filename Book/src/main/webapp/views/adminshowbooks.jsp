<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Books</title>
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet"/>

<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.min.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">
			<a class="navbar-brand" href="/home">BookWorm</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNav"
				aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="/home">Home</a></li>
					<li class="nav-item"><a class="nav-link active" href="/loggedin">Login</a></li>
					<li class="nav-item"><a class="nav-link active" href="/admin">Menu</a></li>
					<li class="nav-item"><a class="nav-link active"
						href="/register">Register</a></li>

				</ul>
			</div>
		</div>
	</nav>
	<div class="container">
		<table class="table">
			<thead>
				<tr>
					<th scope="col">Book Name</th>
					<th scope="col">Author</th>
					<th scope="col">Publication</th>
					<th scope="col">Price</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${book }" var="book">
					<tr>
						<td>${book.bookTitle }</td>
						<td>${book.bookAuthor }</td>
						<td>${book.bookPublication }</td>
						<td>${book.price }</td>
						
						 
						
						<td><a	href="/admin/delete/${book.bookId}"><i class="fa fa-trash"></i></a>  </td>
						
					</tr>
				</c:forEach>

			</tbody>
		</table>
	</div>
</body>
</html>