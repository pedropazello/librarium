package ppazello.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import ppazello.dao.authorDao.JdbcAuthorDao;
import ppazello.dao.bookDao.JdbcBookDao;
import ppazello.dao.genreDao.JdbcGenreDao;
import ppazello.dao.publisherDao.JdbcPublisherDao;
import ppazello.model.Book;

@Controller
public class BookController {
	
	private JdbcBookDao dao;
	private JdbcAuthorDao authorDao;
	private JdbcGenreDao genreDao;
	private JdbcPublisherDao publisherDao;
	@Autowired
	public  BookController(JdbcBookDao dao, JdbcAuthorDao authorDao, 
			JdbcGenreDao genreDao, JdbcPublisherDao publisherDao) {
		this.dao = dao;
		this.authorDao = authorDao;
		this.genreDao = genreDao;
		this.publisherDao = publisherDao;
	}
	
	@RequestMapping("/books")
	public String index(Model model) {
		model.addAttribute("books", dao.read()) ;
		return "books/index";
	}
	
	@RequestMapping("/books/new")
	public String newBook(Model model) {
		model.addAttribute("authors", authorDao.read());
		model.addAttribute("genres", genreDao.read());
		model.addAttribute("publishers", publisherDao.read());
		return "books/new";
	}
	
	@RequestMapping("/books/create")
	public String create(@Valid Book book, BindingResult result, Model model) {
		
		if(result.hasFieldErrors()) {
			model.addAttribute("book", book);
			return "books/new";
		}
		dao.create(book);
		model.addAttribute("msg", "Livro cadastrado com sucesso!");
		return "redirect:/books/new";
	}
	

	@RequestMapping("/books/edit")
	public String edit(Book book, Model model) {
		model.addAttribute("book",dao.findById(book));
		model.addAttribute("defaultAuthor", authorDao.findById(book.getAuthor()));
		model.addAttribute("authors", authorDao.read());
		model.addAttribute("defaultGenre", genreDao.findById(book.getGenre()));
		model.addAttribute("genres", genreDao.read());
		model.addAttribute("defaultPublisher", publisherDao.findById(book.getPublisher()));
		model.addAttribute("publishers", publisherDao.read());
		return "books/edit";
	}
	
	@RequestMapping("/books/update")
	public String update(@Valid Book book, BindingResult result,Model model) {
		if(result.hasFieldErrors()) {
			model.addAttribute("book",dao.findById(book));
			return "books/edit";
		}
		dao.update(book);
		model.addAttribute("msg", "Livro alterado com sucesso!");
		return "books/edit";
	}
	
}
