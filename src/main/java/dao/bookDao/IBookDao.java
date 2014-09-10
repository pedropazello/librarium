package dao.bookDao;

import java.util.List;

import model.Book;

public interface IBookDao {
	public void create(Book book);
	public List<Book> read();
	public void update(Book book);
	public void delete(Book book);
	public Book search(Book book);
}
