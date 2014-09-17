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
		String sql = "INSERT INTO publishers (name,email,site,phoneNumber) VALUES (?,?,?,?) ";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, publisher.getName());
			stmt.setString(2, publisher.getEmail());
			stmt.setString(3, publisher.getSite());
			stmt.setString(4, publisher.getPhoneNumber());
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Publisher> read() {
		String sql = "SELECT * FROM publishers";
		List<Publisher> publishers = new ArrayList<Publisher>();
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Publisher publisher = new Publisher();
				publisher.setId(rs.getLong("id"));
				publisher.setName(rs.getString("name"));
				publisher.setEmail(rs.getString("email"));
				publisher.setSite(rs.getString("site"));
				publisher.setPhoneNumber(rs.getString("phoneNumber"));
				publishers.add(publisher);
			}
			rs.close();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return publishers;
	}

	public void update(Publisher publisher) {
		String sql = "UPDATE publishers SET name=?, email=?, site=?, phoneNumber=? WHERE id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			int i = 1;
			stmt.setString(i++, publisher.getName());
			stmt.setString(i++, publisher.getEmail());
			stmt.setString(i++, publisher.getSite());
			stmt.setString(i++, publisher.getPhoneNumber());
			stmt.setLong(i++, publisher.getId());
			stmt.execute();
			stmt.close();
			
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
				publisher.setSite(rs.getString("site"));
				publisher.setPhoneNumber(rs.getString("phoneNumber"));
			}
			rs.close();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return publisher;
	}

}
