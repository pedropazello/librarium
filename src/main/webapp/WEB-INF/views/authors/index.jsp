<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>index</title>
</head>
<body>
<jsp:include page="_menu.jsp"/> <br>
<h3>Todos os autores</h3>
<table>
	<tr>
		<td>id</td>
		<td>nome</td>
		<td>email</td>
		<td>alterar</td>
		<td>deletar</td>
	</tr>
	<c:forEach items="${authors}" var="author" >
		<tr>
			<td>${author.id}</td>
			<td>${author.name}</td>
			<td>${author.email}</td>
			<td><a href="authors/edit?id=${author.id}">alterar</a></td>
			<td><a href="authors/destroy?id=${author.id}">deletar</a></td>
		</tr>
	</c:forEach>
</table>
</body>
</html>