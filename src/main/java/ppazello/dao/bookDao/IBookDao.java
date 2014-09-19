package ppazello.dao.bookDao;

import java.util.List;

import ppazello.model.Author;
import ppazello.model.Book;
import ppazello.model.Genre;
import ppazello.model.Publisher;

public interface IBookDao {
	public void create(Book book);
	public List<Book> read();
	public void update(Book book);
	public Book findById(Book book);
	public List<Book> findByAuthor(Author author);
	public List<Book> findByGenre(Genre genre);
	public List<Book> findByPublisher(Publisher publisher);
}
