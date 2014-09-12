package ppazello.dao.genreDao;

import java.util.List;

import ppazello.model.Genre;

public interface IGenreDao {
	public void create(Genre genre);
	public List<Genre> read();
	public void update(Genre genre);
	public void delete(Genre genre);
	public Genre findById(Genre genre);
}
