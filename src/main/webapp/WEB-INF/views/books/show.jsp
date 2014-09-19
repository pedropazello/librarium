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
		<div class="page-header" ><h1>Livro ${book.name}</h1></div>
		<div class="row">
			<div class="col-lg-5">
				<p><strong>Nome:</strong> ${book.name}</p>
				<p><strong>Preço:</strong> <fmt:formatNumber type="currency" value="${book.price}"/></p>
				<p><strong>ISBN:</strong> ${book.isbn}</p>
				<p><strong>Data de lançamento:</strong> <fmt:formatDate value="${book.launchDate.time}" pattern="dd/MM/yyyy" /> </p>
				<p><strong>Autor:</strong> ${book.author.name}</p>
				<p><strong>Gênero:</strong> ${book.genre.name}</p>
				<p><strong>Editora:</strong> ${book.publisher.name }</p>
			</div>
			<div class="col-lg-5">
				<p><strong>Comentário sobre o livro:</strong></p>
				<p>${book.comment}</p>
			</div>
		</div>
		<jsp:include page="../global/_footer.jsp"/>
	</div>
</body>
</html>