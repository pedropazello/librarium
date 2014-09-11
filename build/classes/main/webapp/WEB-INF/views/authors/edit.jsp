<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar um autor</title>
</head>
<body>
<h3>Alterar ${author.name}</h3>
    <form action="#" method="post">
       <label>Nome</label> 
	   <input type="text" name="name" value="${author.name}" /> <br>
	   <label>Email</label> 
	   <input type="text" name="email" value="${author.email}" /> <br>
       <input type="hidden" value="${author.id}">
      <input type="submit" value="Alterar">
    </form>
    
    <form:errors path="author.name"/> <br>
    <form:errors path="author.email"/>
</body>
</html>