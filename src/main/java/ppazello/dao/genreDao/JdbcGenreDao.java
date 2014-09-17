package ppazello.dao.genreDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ppazello.model.Genre;

@Repository
public class JdbcGenreDao implements IGenreDao {
	private Connection connection;
	
	@Autowired
	public JdbcGenreDao(DataSource dataSource) {
		try {
			this.connection = dataSource.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void create(Genre genre) {
		String sql = "INSERT INTO genres (name) values (?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1,genre.getName());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public List<Genre> read() {
		String sql = "SELECT * FROM genres";
		List<Genre> genres = new ArrayList<Genre>();
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Genre genre = new Genre();
				genre.setId(rs.getLong("id"));
				genre.setName(rs.getString("name"));
				genres.add(genre);
			}
			stmt.close();
			rs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return genres;	
	}

	public void update(Genre genre) {
		String sql = "UPDATE genres SET name=? WHERE id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, genre.getName());
			stmt.setLong(2, genre.getId());
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public Genre findById(Genre genre) {
		String sql = "SELECT * FROM genres WHERE id=?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setLong(1, genre.getId());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				genre.setName(rs.getString("name"));
			}
			rs.close();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return genre;
	}

}
