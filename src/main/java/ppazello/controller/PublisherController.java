package ppazello.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import ppazello.dao.bookDao.JdbcBookDao;
import ppazello.dao.publisherDao.JdbcPublisherDao;
import ppazello.model.Publisher;

@Controller
public class PublisherController {
	
	private JdbcPublisherDao dao;
	private JdbcBookDao bookDao;
	@Autowired
	public  PublisherController(JdbcPublisherDao dao, JdbcBookDao bookDao) {
		this.dao = dao;
		this.bookDao = bookDao;
	}
	
	@RequestMapping("/publishers")
	public String index(Model model) {
		model.addAttribute("publishers", dao.read()) ;
		return "publishers/index";
	}
	
	@RequestMapping("/publishers/new")
	public String newPublisher(Model model) {
		return "publishers/new";
	}
	
	@RequestMapping("/publishers/create")
	public String create(@Valid Publisher publisher, BindingResult result, Model model) {
		
		if(result.hasFieldErrors()) {
			model.addAttribute("publisher", publisher);
			return "publishers/new";
		}
		dao.create(publisher);
		model.addAttribute("msg", "Editora cadastrada com sucesso!");
		return "redirect:/publishers/new";
	}
	

	@RequestMapping("/publishers/edit")
	public String edit(Publisher publisher, Model model) {
		model.addAttribute("publisher",dao.findById(publisher));
		return "publishers/edit";
	}
	
	@RequestMapping("/publishers/update")
	public String update(@Valid Publisher publisher, BindingResult result,Model model) {
		if(result.hasFieldErrors()) {
			model.addAttribute("publisher",dao.findById(publisher));
			return "publishers/edit";
		}
		dao.update(publisher);
		model.addAttribute("msg", "Editora alterada com sucesso!");
		return "publishers/edit";
	}
	
	@RequestMapping("/publishers/show")
	public String show(Publisher publisher, Model model) {
		model.addAttribute("publisher", dao.findById(publisher));
		model.addAttribute("books", bookDao.findByPublisher(publisher) );
		return "publishers/show";
	}
	

}
