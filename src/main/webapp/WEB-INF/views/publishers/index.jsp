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
		<div class="page-header" ><h1>Editoras</h1></div>
		<table class="table table-striped table-hover table-bordered">
			<thead>
				<tr>
					<th>#</th>
					<th>nome</th>
					<th>email</th>
					<th>site</th>
					<th>Telefone</th>
					<th>alterar</th>
					<th>deletar</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${publishers}" var="publisher" >
					<tr>
						<td>${publisher.id}</td>
						<td>${publisher.name}</td>
						<td>${publisher.email}</td>
						<td>${publisher.site}</td>
						<td>${publisher.phoneNumber}</td>
						<td><a href="publishers/edit?id=${publisher.id}">alterar</a></td>
						<td><a href="publishers/destroy?id=${publisher.id}">deletar</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<jsp:include page="_footer.jsp"/>
	</div>
</body>
</html>