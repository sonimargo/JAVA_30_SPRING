package dev.springBootH2.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dev.springBootH2.Model.Book;
import dev.springBootH2.Service.BookService;

@Controller
@RequestMapping("/GestionLibros")
public class BookController {

	@Autowired
	BookService service;

	@RequestMapping("/inicio")
	public String inicio(Model model) 
	{
		return "books/inicio.html";
	}
	
	@RequestMapping("/verListaLibros")
	public String showBooks(Model model) 
	{
		model.addAttribute("listalibros", service.findAll());
		return "books/libros.html";
	}

	//Viene del link de web VER LISTA LIBROS, reenvia a web añadir libro
	@RequestMapping("/nuevoLibro")
	public String addBook(Model model) 
	{
		return "books/webAddLibro.html";
	}
	
	//Muestra la web de insertar libro, donde tenemos la opcion introducir los datos del libro
	// guardar y volver a la web de LISTA LIBROS
	@RequestMapping("/insertarLibro")
	public String insertBook(Book libro, Model model) 
	{
		service.insertBook(libro);
		model.addAttribute("listalibros", service.findAll());
		
		return "books/libros.html";
	}
	
	@RequestMapping("/eliminaLibro")
	public String removeBook(Model model, @RequestParam("libroId") Long idLibro, HttpSession session) 
	{ 	
		List<Book> listaLibros = (List<Book>) session.getAttribute("GestionLibros");
		int index = this.exists(idLibro, listaLibros);
		
		Book libro = listaLibros.get(index);		
		service.deleteBook(libro); 
		
		model.addAttribute("listalibros", service.findAll());
		
		return "books/webEliminarLibro.html";
	}
	
	
	
	
	// metodos propios del controler
	private int exists(Long existeIdBook, List<Book> listaLibros) 
	{
		for (int i = 0; i < listaLibros.size(); i++) 
		{
			if (listaLibros.get(i).getIdBook() == existeIdBook) 
			{
				return i;
			}
		}
		return -1;
	}
}
