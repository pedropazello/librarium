package dao.bookDao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import model.Author;
import model.Book;
import model.Genre;
import model.Publisher;
import connection.ConnectionFactory;

public class JdbcBookDao implements IBookDao {
	protected Connection connection;
	public JdbcBookDao() {
		this.connection = new ConnectionFactory().getConnection();
	}
	
	public void create(Book book) {
		String sql = "INSERT INTO books "
				+ "(name,price,isbn,rating,comment,launchDate,available,authorId,genreId,publisherId) "
				+ "VALUES (?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, book.getName());
			stmt.setDouble(2, book.getPrice());
			stmt.setString(3, book.getIsbn());
			stmt.setDouble(4, book.getRating());
			stmt.setString(5, book.getComment());
			stmt.setDate(6, new Date(Calendar.getInstance().getTimeInMillis()));
			stmt.setBoolean(7, book.getAvailable());
			stmt.setLong(8, book.getAuthor().getId());
			stmt.setLong(9, book.getGenre().getId());
			stmt.setLong(10, book.getPublisher().getId());
			stmt.execute();
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public List<Book> read() {
		String sql = ""
				+ "SELECT books.*,"
				+ "authors.name AS author,"
				+ "genres.name AS genre,"
				+ "publishers.name AS publisher "
				+ "FROM books "
				+ "INNER JOIN authors ON books.authorId = authors.id "
				+ "INNER JOIN genres ON books.genreId = genres.id "
				+ "INNER JOIN publishers ON books.publisherId = publishers.id ";
		List<Book> books = new ArrayList<Book>();
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Book book = new Book();
				Author author = new Author();
				Genre genre = new Genre();
				Publisher publisher = new Publisher();
				book.setId(rs.getLong("id"));
				book.setName(rs.getString("name"));
				book.setPrice(rs.getDouble("price"));
				book.setIsbn(rs.getString("isbn"));
				book.setRating(rs.getDouble("rating"));
				book.setComment(rs.getString("comment"));
				Calendar date = Calendar.getInstance();
				date.setTime(rs.getDate("launchDate"));
				book.setLaunchDate(date);
				book.setAvailable(rs.getBoolean("available"));
				
				author.setId(rs.getLong("authorId"));
				author.setName(rs.getString("author"));
				book.setAuthor(author);
				
				genre.setId(rs.getLong("genreId"));
				genre.setName(rs.getString("genre"));
				book.setGenre(genre);
				
				publisher.setId(rs.getLong("publisherId"));
				publisher.setName(rs.getString("publisher"));
				book.setPublisher(publisher);
				
				books.add(book);
			}
			rs.close();
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return books;
	}

	public void update(Book book) {
		String sql = "UPDATE books WHERE id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, book.getId());
			stmt.execute();
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void delete(Book book) {
		String sql = "DELETE FROM books WHERE id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, book.getId());
			stmt.execute();
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Book search(Book book) {
		String sql = ""
				+ "SELECT books.*,"
				+ "authors.name AS author,"
				+ "genres.name AS genre,"
				+ "publishers.name AS publisher "
				+ "FROM books "
				+ "INNER JOIN authors ON books.authorId = authors.id "
				+ "INNER JOIN genres ON books.genreId = genres.id "
				+ "INNER JOIN publishers ON books.publisherId = publishers.id "
				+ "WHERE books.id = ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, book.getId());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Author author = new Author();
				Genre genre = new Genre();
				Publisher publisher = new Publisher();
				book.setId(rs.getLong("id"));
				book.setName(rs.getString("name"));
				book.setPrice(rs.getDouble("price"));
				book.setIsbn(rs.getString("isbn"));
				book.setRating(rs.getDouble("rating"));
				book.setComment(rs.getString("comment"));
				Calendar date = Calendar.getInstance();
				date.setTime(rs.getDate("launchDate"));
				book.setLaunchDate(date);
				book.setAvailable(rs.getBoolean("available"));
				
				author.setId(rs.getLong("authorId"));
				author.setName(rs.getString("author"));
				book.setAuthor(author);
				
				genre.setId(rs.getLong("genreId"));
				genre.setName(rs.getString("genre"));
				book.setGenre(genre);
				
				publisher.setId(rs.getLong("publisherId"));
				publisher.setName(rs.getString("publisher"));
				book.setPublisher(publisher);
			}
			stmt.close();
			rs.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return book;
	}

}
