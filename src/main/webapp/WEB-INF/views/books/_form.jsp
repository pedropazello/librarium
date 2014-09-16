<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<p class="text-danger" >* Campos obrigatórios</p>
<div class="row">
	<div class="col-lg-4">
		<div class="form-group">
			<label>Nome*</label>
			<input name="name" class="form-control" value="${book.name}" placeholder="Nome" />
			<p class="text-danger"><form:errors path="book.name"/></p>
		</div>
		<div class="form-group">
			<label>Preço</label>
			<input name="price" class="form-control"  
			value="${book.price}" placeholder="Preço" />
			<p class="text-danger"><form:errors path="book.price"/></p>
		</div>
		<div class="form-group">
			<label>ISBN</label>
			<input name="isbn" class="form-control"  value="${book.isbn}" placeholder="ISBN" />
			<p class="text-danger"><form:errors path="book.isbn"/></p>
		</div>
		
		<div class="form-group">
			<label>Data de lançamento</label>
			<input name="lanchDate" class="form-control" 
			 value="<fmt:formatDate value="${book.launchDate.time}" pattern="dd/MM/yyyy" />" 
			 placeholder="Data de lançamento" />
			<p class="text-danger"><form:errors path="book.launchDate"/></p>
		</div>
	</div>
	<div class="col-lg-4">
		<div class="form-group">
			<label>Cometários sobre o livro</label>
			<textarea name="price" class="form-control" placeholder="Comentários">${book.comment}</textarea>
			<p class="text-danger"><form:errors path="book.comment"/></p>
		</div>
		<div class="form-group">
			<label>Autor</label>
			<select name="author.id" class="form-control">
				<c:if test="${not empty defaultAuthor}">
		  			<option value="${defaultAuthor.id}" >${defaultAuthor.name}</option>
		  		</c:if>
		  		<c:forEach items="${authors}" var="author">	
		  		<option value="${author.id}" >${author.name}</option>
		  		</c:forEach>
			</select>
			<p class="text-danger"><form:errors path="book.author"/></p>
		</div>
		<div class="form-group">
			<label>Gênero</label>
			<select name="genre.id" class="form-control">
				<c:if test="${not empty defaultGenre}">
		  			<option value="${defaultGenre.id}" >${defaultGenre.name}</option>
		  		</c:if>
		  		<c:forEach items="${genres}" var="genre">
		  		<option value="${genre.id}" >${genre.name}</option>
		  		</c:forEach>
			</select>
			<p class="text-danger"><form:errors path="book.genre"/></p>
		</div>
		<div class="form-group">
			<label>Editora</label>
			<select name="publisher.id" class="form-control">
				<c:if test="${not empty defaultPublisher}">
		  			<option value="${defaultPublisher.id}" >${defaultPublisher.name}</option>
		  		</c:if>
		  		<c:forEach items="${publishers}" var="publisher">
		  		<option value="${publisher.id}" >${publisher.name}</option>
		  		</c:forEach>
			</select>
			<p class="text-danger"><form:errors path="book.publisher"/></p>
		</div>
	</div>
</div>

