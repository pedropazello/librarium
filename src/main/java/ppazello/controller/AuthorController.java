package ppazello.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import ppazello.dao.authorDao.JdbcAuthorDao;
import ppazello.model.Author;

@Controller
public class AuthorController {
	
	private final  JdbcAuthorDao dao;
	
	@Autowired
	public  AuthorController(JdbcAuthorDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping("/authors")
	public String index(Model model) {
		model.addAttribute("authors", dao.read()) ;
		return "authors/index";
	}
	
	@RequestMapping("/authors/new")
	public String newAuthor(Model model) {
		model.addAttribute("action", "cadastrar");
		return "authors/new";
	}
	
	@RequestMapping("/authors/create")
	public String create(@Valid Author author, BindingResult result, Model model) {
		
		if(result.hasFieldErrors()) {
			model.addAttribute("author", author);
			return "authors/new";
		}
		dao.create(author);
		model.addAttribute("msg", "Autor cadastrado com sucesso!");
		return "redirect:/authors/new";
	}
	

	@RequestMapping("/authors/edit")
	public String edit(Author author, Model model) {
		model.addAttribute("author",dao.findById(author));
		return "authors/edit";
	}
	
	@RequestMapping("/authors/update")
	public String update(@Valid Author author, BindingResult result,Model model) {
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
		dao.delete(author);
		return "redirect:/authors";
	}
	
}
