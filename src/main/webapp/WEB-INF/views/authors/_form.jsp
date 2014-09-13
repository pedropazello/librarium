<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<div class="form-group">
	<label>Nome</label>
	<input name="name" class="form-control" value="${author.name}" placeholder="Nome" />
	<p class="text-danger"><form:errors path="author.name"/></p>
</div>
<div class="form-group">
	<label>Email</label>
	<input name="email" class="form-control"  value="${author.email}" placeholder="Email" />
	<p class="text-danger"><form:errors path="author.email"/></p>
</div>