package dev.springBootH2.Controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

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
	public String addAutor(Autor autor, Model model, HttpSession sesion)
	{
		//Buscar la lista de libros que tiene el autor
		//Optional<Book> bookBuscado = serviceBook.findById(id);
		List<Book> listadoDeLibros = (List<Book>) serviceBook.findAll();
		
		//Si todo es corecto, establecer la lista de libros para este autor
//		if (bookBuscado.isPresent())  
	//		autor.setListaDelibros(listadoDeLibros);
//		else 
	
		// En esta opción No se dan de alta los libros
		autor.setListaDelibros(null);		
		
		serviceAutor.insertAutor(autor);
		
		model.addAttribute("listaAutores", serviceAutor.findAll());
		return "autores/listadoAutores.html";
	}
}


