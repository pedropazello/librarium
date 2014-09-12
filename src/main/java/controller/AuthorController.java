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
	public String index(Model model) {
		IAuthorDao dao = new JdbcAuthorDao();
		model.addAttribute("authors", dao.read()) ;
		return "authors/index";
	}
	
	@RequestMapping("/authors/new")
	public String newAuthor() {
		return "authors/new";
	}
	
	@RequestMapping("authors/show")
	public String show(Author author, Model model) {
		IAuthorDao dao = new JdbcAuthorDao();
		model.addAttribute("author", dao.findById(author));
		return "authors/show";
	}
	
	@RequestMapping("/authors/create")
	public String create(@Valid Author author, BindingResult result, Model model) {
		
		if(result.hasFieldErrors()) {
			return "authors/new";
		}
		JdbcAuthorDao dao = new JdbcAuthorDao();
		dao.create(author);
		model.addAttribute("msg", "Autor criado com sucesso!");
		return "authors/new";
	}
	
	@RequestMapping("/authors/edit")
	public String edit(Author author, Model model) {
		IAuthorDao dao = new JdbcAuthorDao();
		model.addAttribute("author",dao.findById(author));
		return "authors/edit";
	}
	
	@RequestMapping("/authors/update")
	public String update(@Valid Author author, BindingResult result,Model model) {
		IAuthorDao dao = new JdbcAuthorDao();
		if(result.hasFieldErrors()) {
			model.addAttribute("author",dao.findById(author));
			return "authors/edit";
		}
		dao.update(author);
		model.addAttribute("msg", "Autor alterado com sucesso!");
		return "authors/edit";
	}
	
	@RequestMapping("/authors/destroy")
	public String destroy(Author author) {
		IAuthorDao dao = new JdbcAuthorDao();
		dao.delete(author);
		return "redirect:/authors";
	}
	
}
