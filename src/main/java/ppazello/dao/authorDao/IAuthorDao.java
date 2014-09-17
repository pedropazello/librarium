package ppazello.dao.authorDao;

import java.util.List;

import ppazello.model.Author;

public interface IAuthorDao {
	public void create(Author author);
	public List<Author> read();
	public void update(Author author);
	public Author findById(Author author);
}
