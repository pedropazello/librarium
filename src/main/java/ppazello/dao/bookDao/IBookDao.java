package ppazello.dao.bookDao;

import java.util.List;

import ppazello.model.Book;

public interface IBookDao {
	public void create(Book book);
	public List<Book> read();
	public void update(Book book);
	public Book findById(Book book);
}
