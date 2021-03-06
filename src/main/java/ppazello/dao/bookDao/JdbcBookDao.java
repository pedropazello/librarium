package ppazello.dao.bookDao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ppazello.model.Author;
import ppazello.model.Book;
import ppazello.model.Genre;
import ppazello.model.Publisher;

@Repository
public class JdbcBookDao implements IBookDao {
	
	protected  Connection connection;
	
	@Autowired
	public JdbcBookDao(DataSource dataSource) {
		try {
			this.connection = dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void create(Book book) {
		String sql = "INSERT INTO books "
				+ "(name,price,isbn,comment,launchYear,authorId,genreId,publisherId) "
				+ "VALUES (?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			int i = 1;
			stmt.setString(i++, book.getName());
			stmt.setBigDecimal(i++, book.getPrice());
			stmt.setString(i++, book.getIsbn());
			stmt.setString(i++, book.getComment());
			Date date = new Date(book.getLaunchYear().getTimeInMillis());
			stmt.setDate(i++, date);
			stmt.setLong(i++, book.getAuthor().getId());
			stmt.setLong(i++, book.getGenre().getId());
			stmt.setLong(i++, book.getPublisher().getId());
			stmt.execute();
			
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
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
				book.setPrice(rs.getBigDecimal("price"));
				book.setIsbn(rs.getString("isbn"));
				book.setComment(rs.getString("comment"));
				Calendar date = Calendar.getInstance();
				date.setTime(rs.getDate("launchYear"));
				book.setLaunchYear(date);
				
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
			
			
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return books;
	}

	public void update(Book book) {
		String sql = "UPDATE books SET name=?, price=?, isbn=?, comment=?, launchYear=?, "
				+ "authorId=?, genreId=?, publisherId=?  WHERE id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			int i = 1;
			stmt.setString(i++, book.getName());
			stmt.setBigDecimal(i++, book.getPrice());
			stmt.setString(i++, book.getIsbn());
			stmt.setString(i++, book.getComment());
			Date date = new Date(book.getLaunchYear().getTimeInMillis());
			stmt.setDate(i++, date);
			stmt.setLong(i++, book.getAuthor().getId());
			stmt.setLong(i++, book.getGenre().getId());
			stmt.setLong(i++, book.getPublisher().getId());
			stmt.setLong(i++, book.getId());
			stmt.execute();
			
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}

	public Book findById(Book book) {
		String sql = ""
				+ "SELECT books.*,"
				+ "authors.id AS authorId,"
				+ "authors.name AS author,"
				+ "genres.id AS genreId,"
				+ "genres.name AS genre,"
				+ "publishers.id AS publisherId,"
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
				book.setPrice(rs.getBigDecimal("price").setScale(2));
				book.setIsbn(rs.getString("isbn"));
				book.setComment(rs.getString("comment"));
				Calendar date = Calendar.getInstance();
				date.setTime(rs.getDate("launchYear"));
				book.setLaunchYear(date);
				
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
			
			
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return book;
	}

	@Override
	public List<Book> findByAuthor(Author author) {
		String Sql = "SELECT * FROM books WHERE authorId=?";
		List<Book> books = new ArrayList<Book>();
		try {
			PreparedStatement stmt = connection.prepareStatement(Sql);
			stmt.setLong(1, author.getId());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Book book = new Book();
				book.setId(rs.getLong("id"));
				book.setName(rs.getString("name"));
				book.setPrice(rs.getBigDecimal("price").setScale(2));
				book.setIsbn(rs.getString("isbn"));
				book.setComment(rs.getString("comment"));
				Calendar date = Calendar.getInstance();
				date.setTime(rs.getDate("launchYear"));
				book.setLaunchYear(date);
				books.add(book);
			}
			
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return books;
	}

	@Override
	public List<Book> findByGenre(Genre genre) {
		String Sql = "SELECT * FROM books WHERE genreId=?";
		List<Book> books = new ArrayList<Book>();
		try {
			PreparedStatement stmt = connection.prepareStatement(Sql);
			stmt.setLong(1, genre.getId());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Book book = new Book();
				book.setId(rs.getLong("id"));
				book.setName(rs.getString("name"));
				book.setPrice(rs.getBigDecimal("price").setScale(2));
				book.setIsbn(rs.getString("isbn"));
				book.setComment(rs.getString("comment"));
				Calendar date = Calendar.getInstance();
				date.setTime(rs.getDate("launchYear"));
				book.setLaunchYear(date);
				books.add(book);
			}
			
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return books;
	}

	@Override
	public List<Book> findByPublisher(Publisher publisher) {
		String Sql = "SELECT * FROM books WHERE publisherId=?";
		List<Book> books = new ArrayList<Book>();
		try {
			PreparedStatement stmt = connection.prepareStatement(Sql);
			stmt.setLong(1, publisher.getId());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Book book = new Book();
				book.setId(rs.getLong("id"));
				book.setName(rs.getString("name"));
				book.setPrice(rs.getBigDecimal("price").setScale(2));
				book.setIsbn(rs.getString("isbn"));
				book.setComment(rs.getString("comment"));
				Calendar date = Calendar.getInstance();
				date.setTime(rs.getDate("launchYear"));
				book.setLaunchYear(date);
				books.add(book);
			}
			
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return books;
	}


}
