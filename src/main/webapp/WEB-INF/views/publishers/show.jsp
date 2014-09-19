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
		<div class="page-header" ><h1>Editora ${publisher.name}</h1></div>
			<p><strong>Nome:</strong> ${publisher.name}</p>
			<p><strong>Email:</strong> ${publisher.email}</p>
			<p><strong>Site:</strong> <a href="${publisher.site}" target="_blank" >${publisher.site}</a></p>
			<p><strong>Telefone:</strong> ${publisher.phoneNumber} </p>
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