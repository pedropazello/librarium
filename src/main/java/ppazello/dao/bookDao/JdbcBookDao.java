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
				+ "(name,price,isbn,comment,launchDate,authorId,genreId,publisherId) "
				+ "VALUES (?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			int i = 1;
			stmt.setString(i++, book.getName());
			stmt.setDouble(i++, book.getPrice());
			stmt.setString(i++, book.getIsbn());
			stmt.setString(i++, book.getComment());
			stmt.setDate(i++, new Date(Calendar.getInstance().getTimeInMillis()));
			stmt.setLong(i++, book.getAuthor().getId());
			stmt.setLong(i++, book.getGenre().getId());
			stmt.setLong(i++, book.getPublisher().getId());
			stmt.execute();
			stmt.close();
			
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
				book.setComment(rs.getString("comment"));
				Calendar date = Calendar.getInstance();
				date.setTime(rs.getDate("launchDate"));
				book.setLaunchDate(date);
				
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
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return books;
	}

	public void update(Book book) {
		String sql = "UPDATE books SET name=?, price=?, isbn=?, comment=?, launchDate=?, "
				+ "authorId=?, genreId=?, publisherId=?  WHERE id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			int i = 1;
			stmt.setString(i++, book.getName());
			stmt.setDouble(i++, book.getPrice());
			stmt.setString(i++, book.getIsbn());
			stmt.setString(i++, book.getComment());
			stmt.setDate(i++, new Date(Calendar.getInstance().getTimeInMillis()));
			stmt.setLong(i++, book.getAuthor().getId());
			stmt.setLong(i++, book.getGenre().getId());
			stmt.setLong(i++, book.getPublisher().getId());
			stmt.setLong(i++, book.getId());
			stmt.execute();
			stmt.close();
			
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
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Book findById(Book book) {
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
				book.setComment(rs.getString("comment"));
				Calendar date = Calendar.getInstance();
				date.setTime(rs.getDate("launchDate"));
				book.setLaunchDate(date);
				
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
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return book;
	}

}
