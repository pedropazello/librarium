package ppazello.dao.authorDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ppazello.model.Author;


@Repository
public class JdbcAuthorDao implements IAuthorDao {
	private  Connection connection;
	
	@Autowired
	public JdbcAuthorDao(DataSource dataSource) {
		try {
			this.connection = dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void create(Author author) {
		String sql = "INSERT INTO authors (name,email) VALUES (?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, author.getName());
			stmt.setString(2, author.getEmail());
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public List<Author> read() {
		String sql = "SELECT * FROM authors";
		List<Author> authors = new ArrayList<Author>();
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Author author = new Author();
				author.setId(rs.getLong("id"));
				author.setName(rs.getString("name"));
				author.setEmail(rs.getString("email"));
				authors.add(author);
			}
			rs.close();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return authors;
	}

	public void update(Author author) {
		String sql = "UPDATE authors SET name=?, email=? WHERE id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, author.getName());
			stmt.setString(2, author.getEmail());
			stmt.setLong(3, author.getId());
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public Author findById(Author author) {
		String sql = "SELECT * FROM authors WHERE id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, author.getId());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				author.setName(rs.getString("name"));
				author.setEmail(rs.getString("email"));
			}
			rs.close();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return author;
	}

}
