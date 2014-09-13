<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<jsp:include page="_assets.jsp"/>
<title>Adicionar um genero</title>
</head>
<body>
<div class="container">
	<jsp:include page="_menu.jsp"/>
	<div class="page-header"><h1>Cadastrar um novo genero</h1></div>
	<div class="col-lg-3" >
		<form action="create" method="post">
			<jsp:include page="_form.jsp"/>
			<button type="submit" class="btn btn-primary">Cadastrar</button>
			<p class="text-success" >${param.msg}</p>
		</form>
	</div>
</div>
</body>
</html>