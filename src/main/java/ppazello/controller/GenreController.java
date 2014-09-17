package ppazello.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import ppazello.dao.genreDao.JdbcGenreDao;
import ppazello.model.Genre;

@Controller
public class GenreController {
	
	private final  JdbcGenreDao dao;
	
	@Autowired
	public  GenreController(JdbcGenreDao dao) {
		this.dao = dao;
	}
	
	@RequestMapping("/genres")
	public String index(Model model) {
		model.addAttribute("genres", dao.read()) ;
		return "genres/index";
	}
	
	@RequestMapping("/genres/new")
	public String newGenre(Model model) {
		return "genres/new";
	}
	
	@RequestMapping("/genres/create")
	public String create(@Valid Genre genre, BindingResult result, Model model) {
		
		if(result.hasFieldErrors()) {
			model.addAttribute("genre", genre);
			return "genres/new";
		}
		dao.create(genre);
		model.addAttribute("msg", "Genero cadastrado com sucesso!");
		return "redirect:/genres/new";
	}
	

	@RequestMapping("/genres/edit")
	public String edit(Genre genre, Model model) {
		model.addAttribute("genre",dao.findById(genre));
		return "genres/edit";
	}
	
	@RequestMapping("/genres/update")
	public String update(@Valid Genre genre, BindingResult result,Model model) {
		if(result.hasFieldErrors()) {
			model.addAttribute("genre",dao.findById(genre));
			return "genres/edit";
		}
		dao.update(genre);
		model.addAttribute("msg", "Genero alterado com sucesso!");
		return "genres/edit";
	}
	
}
