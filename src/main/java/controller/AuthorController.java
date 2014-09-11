package controller;

import javax.validation.Valid;

import model.Author;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import dao.authorDao.IAuthorDao;
import dao.authorDao.JdbcAuthorDao;

@Controller
public class AuthorController {
	
	@RequestMapping("/authors")
	public String index() {
		return "authors/index";
	}
	
	@RequestMapping("/authors/new")
	public String newAuthor() {
		return "authors/new";
	}
	
	@RequestMapping("/authors/create")
	public String create(@Valid Author author, BindingResult result) {
		
		if(result.hasFieldErrors()) {
			return "authors/new";
		}
		JdbcAuthorDao dao = new JdbcAuthorDao();
		dao.create(author);
		return "authors/index";
	}
	
	@RequestMapping("/authors/edit")
	public String edit(Author author, Model model) {
		IAuthorDao dao = new JdbcAuthorDao();
		model.addAttribute("author",dao.findById(author));
		return "authors/edit";
	}
	
}
