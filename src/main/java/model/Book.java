package model;

public class Book {
	
	public Book() {
		this.rating = 0.0;
	}
	
	private Long id;
	private String name;
	private double price;
	private String isbn;
	private double rating;
	private String comment;
	private Author author;
	private Genre genre;
	private Publisher publiser;
	private boolean available;
	
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
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	public Author getAuthor() {
		return this.author;
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
	
	public Publisher getPubliser() {
		return publiser;
	}
	public void setPubliser(Publisher publiser) {
		this.publiser = publiser;
	}
	
	public boolean isAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", price=" + price
				+ ", isbn=" + isbn + ", rating=" + rating + ", comment="
				+ comment + ", author=" + author.getName() + ", genre=" + genre.getName()
				+ ", publiser=" + publiser.getName() + ", available=" + available + "]";
	}
	
	

}
