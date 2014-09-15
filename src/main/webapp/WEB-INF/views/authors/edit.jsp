<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="../global/_assets.jsp"/>
<title>Editar um autor</title>
</head>
<body>
<div class="container">
	<jsp:include page="_menu.jsp"/>
	<div class="page-header"><h1>Editar o autor ${author.name}</h1></div>
	<div class="col-lg-3" >
		<form action="update" method="post">
			<jsp:include page="_form.jsp"/>
			<input type="hidden" name="id" value="${author.id}" />
			<button type="submit" class="btn btn-primary">Editar</button>
			<p class="text-success" >${msg}</p>
		</form>
	</div>
	<jsp:include page="../global/_footer.jsp"/>
</div>
</body>
</html>