<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<div class="form-group">
	<label>Nome</label>
	<input name="name" class="form-control" value="${genre.name}" placeholder="Nome" />
	<p class="text-danger"><form:errors path="genre.name"/></p>
</div>