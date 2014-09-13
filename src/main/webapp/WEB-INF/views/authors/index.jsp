<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="_assets.jsp"/>
<title>index</title>
</head>
<body role="document">
	<div class="container">
		<!-- Static navbar -->
	    <jsp:include page="_menu.jsp"/>
		<div class="page-header" ><h1>Autores</h1></div>
		<table class="table table-striped table-hover table-bordered">
			<thead>
				<tr>
					<th>#</th>
					<th>nome</th>
					<th>email</th>
					<th>alterar</th>
					<th>deletar</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${authors}" var="author" >
					<tr>
						<td>${author.id}</td>
						<td>${author.name}</td>
						<td>${author.email}</td>
						<td><a href="authors/edit?id=${author.id}">alterar</a></td>
						<td><a href="authors/destroy?id=${author.id}">deletar</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<jsp:include page="_footer.jsp"/>
	</div>
</body>
</html>