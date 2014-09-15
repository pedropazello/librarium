<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<p class="text-danger" >* Campos obrigatórios</p>
<div class="form-group">
	<label>Nome*</label>
	<input name="name" class="form-control" value="${publisher.name}" placeholder="Nome" />
	<p class="text-danger"><form:errors path="publisher.name"/></p>
</div>
<div class="form-group">
	<label>Email</label>
	<input name="email" class="form-control"  value="${publisher.email}" placeholder="Email" />
	<p class="text-danger"><form:errors path="publisher.email"/></p>
</div>
<div class="form-group">
	<label>Site</label>
	<p class="text-primary" >No formato http://exemplo.com</p>
	<input name="site" class="form-control"  value="${publisher.site}" placeholder="Site" />
	<p class="text-danger"><form:errors path="publisher.site"/></p>
</div>
<div class="form-group">
	<label>Telefone</label>
	<input name="phoneNumber" class="form-control"  value="${publisher.phoneNumber}" placeholder="Telefone" />
	<p class="text-danger"><form:errors path="publisher.phoneNumber"/></p>
</div>
