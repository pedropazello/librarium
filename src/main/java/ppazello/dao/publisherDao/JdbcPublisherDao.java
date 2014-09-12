package ppazello.dao.publisherDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ppazello.model.Publisher;

@Repository
public class JdbcPublisherDao implements IPublihserDao {
	protected Connection connection;
	
	@Autowired
	public JdbcPublisherDao(DataSource dataSource) {
		try {
			this.connection = dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void create(Publisher publisher) {
		String sql = "INSERT INTO publishers (name,email,phoneNumber) VALUES (?,?,?) ";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, publisher.getName());
			stmt.setString(2, publisher.getEmail());
			stmt.setString(3, publisher.getPhoneNumber());
			stmt.execute();
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Publisher> read() {
		String sql = "SELECT * FROM publihsers";
		List<Publisher> publishers = new ArrayList<Publisher>();
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Publisher publisher = new Publisher();
				publisher.setId(rs.getLong("id"));
				publisher.setName(rs.getString("name"));
				publisher.setEmail(rs.getString("email"));
				publisher.setPhoneNumber(rs.getString("phoneNumber"));
				publishers.add(publisher);
			}
			rs.close();
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return publishers;
	}

	public void update(Publisher publisher) {
		String sql = "UPDATE publishers SET name=?, email=?, phoneNumber=? WHERE id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, publisher.getName());
			stmt.setString(2, publisher.getEmail());
			stmt.setString(3, publisher.getPhoneNumber());
			stmt.setLong(4, publisher.getId());
			stmt.execute();
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void delete(Publisher publisher) {
		String sql = "DELETE FROM publishers WHERE id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, publisher.getId());
			stmt.execute();
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public Publisher findById(Publisher publisher) {
		String sql = "SELECT * FROM publishers WHERE id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, publisher.getId());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				publisher.setName(rs.getString("name"));
				publisher.setEmail(rs.getString("email"));
				publisher.setPhoneNumber(rs.getString("phoneNumber"));
			}
			rs.close();
			stmt.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return publisher;
	}

}
