package dao.publisherDao;

import java.util.List;

import model.Publisher;

public interface IPublihserDao {
	public void create(Publisher publisher);
	public List<Publisher> read();
	public void update(Publisher publiser);
	public void delete(Publisher publisher);
	public Publisher findById(Publisher publisher);
}
