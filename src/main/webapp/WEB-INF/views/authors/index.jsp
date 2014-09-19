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
		<div class="page-header" ><h1>Autores</h1></div>
		<table class="table table-striped table-hover table-bordered">
			<thead>
				<tr>
					<th>#</th>
					<th>Nome</th>
					<th>Email</th>
					<th>Opção</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${authors}" var="author" >
					<tr>
						<td>${author.id}</td>
						<td><a href="authors/show?id=${author.id }">${author.name}</a> </td>
						<td><a href="mailto:${author.email}">${author.email}</a>
							<c:if test="${empty author.email}">email vazio</c:if>
						</td>
						<td><a href="authors/edit?id=${author.id}">alterar</a></td>
					</tr>
				</c:forEach>
				<c:if test="${empty authors}">
					<tr>
						<td colspan="4">Sem autores cadastrados</td>
					</tr>
				</c:if>
			</tbody>
		</table>
		<jsp:include page="../global/_footer.jsp"/>
	</div>
</body>
</html>