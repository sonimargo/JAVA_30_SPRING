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

	@RequestMapping("/inicio")
	public String inicio(Model model) 
	{
		return "books/inicio.html";
	}
	
	@RequestMapping("/libros")
	public String showBooks(Model model) 
	{
		model.addAttribute("listalibros", service.findAll());
		return "books/libros.html";
	}

	//Parte de link de web LISTA LIBROS, reenvia a web añadir libro
	@RequestMapping("/nuevoLibro")
	public String addBook(Model model) 
	{
		return "books/webAddLibro.html";
	}
	
	//Muestra la web de insertar libro, donde tenemos la opcion introducir los datos del libro
	// guardar y volver a la web de LISTA LIBROS
	@RequestMapping("/insertarLibro")
	public String insertBook(Book libro,Model model) 
	{
		service.insertBook(libro);
		model.addAttribute("listalibros", service.findAll());
		
		return "books/libros.html";
	}
	
	@RequestMapping("/eliminaLibro")
	public String removeBook(Model model) 
	{
		return "books/webEliminarLibro.html";
	}
}
