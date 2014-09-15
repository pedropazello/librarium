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
					<th>nome</th>
					<th>alterar</th>
					<th>deletar</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${genres}" var="genre" >
					<tr>
						<td>${genre.id}</td>
						<td>${genre.name}</td>
						<td><a href="genres/edit?id=${genre.id}">alterar</a></td>
						<td><a href="genres/destroy?id=${genre.id}">deletar</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<jsp:include page="../global/_footer.jsp"/>
	</div>
</body>
</html>