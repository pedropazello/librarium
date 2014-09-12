package dao.authorDao;

import java.util.List;

import model.Author;

public interface IAuthorDao {
	public void create(Author author);
	public List<Author> read();
	public void update(Author author);
	public void delete(Author author);
	public Author findById(Author author);
}
