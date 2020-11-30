package dev.springBootH2.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dev.springBootH2.Model.Autor;
import dev.springBootH2.Model.Book;
import dev.springBootH2.Service.AutorService;
import dev.springBootH2.Service.BookService;


@Controller
@RequestMapping("/GestionAutores")
public class AutorController 
{
	
	@Autowired
	AutorService serviceAutor;

	@Autowired
	BookService serviceBook;

	
	@RequestMapping("/verListadoAutores")
	public String showAutores(Model model)
	{
		model.addAttribute("listaAutores", serviceAutor.findAll());
		return "autores/listadoAutores.html";
	}
	
	@RequestMapping("/nuevoAutor")
	public String addAutor(Model model) 
	{
		return "autores/webAddAutor.html";
	}
	
	
	@RequestMapping("/insertarAutor")
	public String addAutor(Autor autor, Model model, @RequestParam("idAutor") Long id)
	{
		//Buscar el objeto padre
		Optional<Book> bookBuscado = serviceBook.findById(id);
		
		//Si todo es corecto, establecer el autor para este libro
		if (bookBuscado.isPresent())  autor.setLibro(bookBuscado.get());
		else autor.setLibro(null);
		
		
		serviceAutor.insertAutor(autor);
		
		model.addAttribute("listaAutores", serviceAutor.findAll());
		return "autores/listadoAutores.html";
	}
}
