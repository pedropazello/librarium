package ppazello.model;

import java.math.BigDecimal;
import java.util.Calendar;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

public class Book {
	

	private Long id;
	@NotEmpty(message="Campo nome não pode estar vazio")
	private String name;
	@NumberFormat
	private BigDecimal price;
	private String isbn;
	private String comment;
	@NotNull(message="Campo data não pode estar vazio")
	@DateTimeFormat(pattern="yyyy") 
	private Calendar launchYear;
	private Author author;
	private Genre genre;
	private Publisher publisher;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Calendar getLaunchYear() {
		return launchYear;
	}
	public void setLaunchYear(Calendar launchDate) {
		this.launchYear = launchDate;
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
	public Publisher getPublisher() {
		return publisher;
	}
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	
	

}
