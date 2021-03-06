<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<p class="text-danger" >* Campos obrigat�rios</p>
<div class="row">
	<div class="col-lg-4">
		<div class="form-group">
			<label>Nome*</label>
			<input name="name" class="form-control" value="${book.name}" placeholder="Nome" />
			<p class="text-danger"><form:errors path="book.name"/></p>
		</div>
		<div class="form-group">
			<label>Pre�o</label>
			<p class="text-primary" >Insira um valor no formato 99,99</p>
			<div class="input-group">
				<div class="input-group-addon">R$</div>
				<input name="price" id="price" class="form-control"  
				value="${book.price}" placeholder="Pre�o" />
			</div>
			<p class="text-danger"><form:errors path="book.price"/></p>
		</div>
		<div class="form-group">
			<label>ISBN</label>
			<input name="isbn" class="form-control"  value="${book.isbn}" placeholder="ISBN" />
			<p class="text-danger"><form:errors path="book.isbn"/></p>
		</div>
		
		<div class="form-group">
			<label>Ano de lan�amento*</label>
			<p class="text-primary" >Insira no formato aaaa</p>
			<input name="launchYear" id="date" class="form-control" 
			 value="<fmt:formatDate value="${book.launchYear.time}" pattern="yyyy" />" 
			 placeholder="Ano de lan�amento" />
			<p class="text-danger"><form:errors path="book.launchYear"/></p>
		</div>
	</div>
	<div class="col-lg-4">
		<div class="form-group">
			<label>Comet�rios sobre o livro</label>
			<textarea name="comment" class="form-control" placeholder="Coment�rios">${book.comment}</textarea>
			<p class="text-danger"><form:errors path="book.comment"/></p>
		</div>
		<div class="form-group">
			<label>Autor*</label>
			<select name="author.id" class="form-control">
				<c:if test="${not empty book.author}">
		  			<option value="${book.author.id}" >${book.author.name}</option>
		  		</c:if>
		  		<c:forEach items="${authors}" var="author">	
		  		<option value="${author.id}" >${author.name}</option>
		  		</c:forEach>
			</select>
			<p class="text-danger"><form:errors path="book.author"/></p>
		</div>
		<div class="form-group">
			<label>G�nero*</label>
			<select name="genre.id" class="form-control">
				<c:if test="${not empty book.genre}">
		  			<option value="${book.genre.id}" >${book.genre.name}</option>
		  		</c:if>
		  		<c:forEach items="${genres}" var="genre">
		  		<option value="${genre.id}" >${genre.name}</option>
		  		</c:forEach>
			</select>
			<p class="text-danger"><form:errors path="book.genre"/></p>
		</div>
		<div class="form-group">
			<label>Editora*</label>
			<select name="publisher.id" class="form-control">
				<c:if test="${not empty book.publisher}">
		  			<option value="${book.publisher.id}" >${book.publisher.name}</option>
		  		</c:if>
		  		<c:forEach items="${publishers}" var="publisher">
		  		<option value="${publisher.id}" >${publisher.name}</option>
		  		</c:forEach>
			</select>
			<p class="text-danger"><form:errors path="book.publisher"/></p>
		</div>
	</div>
</div>

