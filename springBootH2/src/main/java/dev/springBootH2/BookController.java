package dev.springBootH2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/biblioteca")
public class BookController {

	@Autowired
	BookService service;

	@RequestMapping("/libros")
	public String showBooks(Model model) 
	{
		model.addAttribute("listalibros", service.findAll());
		return "books/libros.html";
	}

}
