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
		<div class="page-header" ><h1>Editoras</h1></div>
		<table class="table table-striped table-hover table-bordered">
			<thead>
				<tr>
					<th>#</th>
					<th>nome</th>
					<th>email</th>
					<th>site</th>
					<th>telefone</th>
					<th>alterar</th>
					<th>deletar</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${publishers}" var="publisher" >
					<tr>
						<td>${publisher.id}</td>
						<td>${publisher.name}</td>
						<td><a href="mailto:${publisher.email}">${publisher.email}</a>
							<c:if test="${empty publisher.email}">email vazio</c:if>
						</td>
						<td><a href="${publisher.site}" target="_blank" >${publisher.site}</a>  
							<c:if test="${empty publisher.site}">site vazio</c:if>
						</td>
						<td> ${publisher.phoneNumber}
							<c:if test="${empty publisher.phoneNumber}">telefone vazio</c:if>
						</td>
						<td><a href="publishers/edit?id=${publisher.id}">alterar</a></td>
						<td><a href="publishers/destroy?id=${publisher.id}">deletar</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<jsp:include page="../global/_footer.jsp"/>
	</div>
</body>
</html>