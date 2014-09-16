<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="../global/_assets.jsp"/>
<title>index</title>
</head>
<body role="document">
	<div class="container">
		<!-- Static navbar -->
	    <jsp:include page="_menu.jsp"/>
		<div class="page-header" ><h1>Livros</h1></div>
		<table class="table table-striped table-hover table-bordered">
			<thead>
				<tr>
					<th>#</th>
					<th>nome</th>
					<th>preço</th>
					<th>ISBN</th>
					<th>Data de lançamento</th>
					<th>Autor</th>
					<th>Gênero</th>
					<th>Editora</th>
					<th>alterar</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${books}" var="book" >
					<tr>
						<td>${book.id}</td>
						<td>${book.name}</td>
						<td>
							<fmt:formatNumber type="currency" value="${book.price}"/>  
						</td>
						<td>${book.isbn}</td>
						<td>
							<fmt:formatDate value="${book.launchDate.time}" pattern="dd/MM/yyyy" />
						</td>
						<td>${book.author.name}</td>
						<td>${book.genre.name}</td>
						<td>${book.publisher.name}</td>
						<td><a href="books/edit?id=${book.id}">alterar</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<jsp:include page="../global/_footer.jsp"/>
	</div>
</body>
</html>