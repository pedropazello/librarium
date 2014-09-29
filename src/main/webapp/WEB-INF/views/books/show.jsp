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
				<p><strong>Pre�o:</strong> <fmt:formatNumber type="currency" value="${book.price}"/></p>
				<p><strong>ISBN:</strong> ${book.isbn}</p>
				<p><strong>Ano de lan�amento:</strong> <fmt:formatDate value="${book.launchYear.time}" pattern="yyyy" /> </p>
				<p><strong>Autor:</strong> <a href="/authors/show?id=${book.author.id}">${book.author.name}</a> </p>
				<p><strong>G�nero:</strong> <a href="/genres/show?id=${book.genre.id}">${book.genre.name}</a> </p>
				<p><strong>Editora:</strong> <a href="/publishers/show?id=${book.publisher.id}">${book.publisher.name }</a> </p>
			</div>
			<div class="col-lg-5">
				<p><strong>Coment�rio sobre o livro:</strong></p>
				<p>${book.comment}</p>
			</div>
		</div>
		<jsp:include page="../global/_footer.jsp"/>
	</div>
</body>
</html>