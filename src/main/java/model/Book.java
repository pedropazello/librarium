package model;

import java.util.Calendar;

public class Book {
	
	
	private Long id;
	private String name;
	private double price;
	private String isbn;
	private String comment;
	private Calendar launchDate;
	private int quantity;
	private boolean available;
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
	
	
	public boolean getAvailable() {
		return available;
	}
	public void setAvailable(boolean available) {
		this.available = available;
	}
	
	public Calendar getLaunchDate() {
		return launchDate;
	}
	public void setLaunchDate(Calendar launchDate) {
		this.launchDate = launchDate;
	}
	
	
	public Publisher getPublisher() {
		return publisher;
	}
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		if(quantity == 0) {
			this.available = false;
		}
		this.quantity = quantity;
	}

}
