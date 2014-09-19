<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
		<div class="page-header" ><h1>Gêneros</h1></div>
		<table class="table table-striped table-hover table-bordered">
			<thead>
				<tr>
					<th>#</th>
					<th>Nome</th>
					<th>Opção</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${genres}" var="genre" >
					<tr>
						<td>${genre.id}</td>
						<td><a href="genres/show?id=${genre.id}">${genre.name}</a></td>
						<td><a href="genres/edit?id=${genre.id}">alterar</a></td>
					</tr>
				</c:forEach>
				<c:if test="${empty genres}">
					<tr>
						<td colspan="4">Sem gêneros cadastrados</td>
					</tr>
				</c:if>
			</tbody>
		</table>
		<jsp:include page="../global/_footer.jsp"/>
	</div>
</body>
</html>