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
		<div class="page-header" ><h1>Gênero ${genre.name}</h1></div>
			<p><strong>Nome:</strong> ${genre.name}</p>
			<p><strong>Livros:</strong></p>
			<c:forEach items="${books}" var="book" >
			<ul>
				<li><a href="/books/show?id=${book.id}">${book.name }</a></li>
			</ul>
			</c:forEach>
		<jsp:include page="../global/_footer.jsp"/>
	</div>
</body>
</html>