<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Adicionar um autor</title>
</head>
<body>
<h3>Adicionar um novo autor</h3>
    <form action="create" method="post">
       <jsp:include page="_form.jsp"/>
      <input type="submit" value="Adicionar">
    </form>
    <form:errors path="author.name"/> <br>
    <form:errors path="author.email"/>
</body>
</html>