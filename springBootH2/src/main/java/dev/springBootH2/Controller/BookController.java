package dev.springBootH2.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dev.springBootH2.Model.Book;
import dev.springBootH2.Service.AutorService;
import dev.springBootH2.Service.BookService;
import dev.springBootH2.Utilitats.EstadoLibro;

@Controller
@RequestMapping("/GestionLibros")
public class BookController {

	@Autowired
	BookService service;
	
	@Autowired
	AutorService serviceAutor;

	@RequestMapping("/inicio")
	public String inicio(Model model) 
	{
		return "inicio/webHome.html";
	}
	
	@RequestMapping("/verListaLibros")
	public String showBooks(Model model, HttpSession sesion) 
	{
		sesion.setAttribute("listadoLibros", service.findAll());		
			
		model.addAttribute("listalibros", service.findAll());
		return "libros/listadoLibros.html";
	}

	//Viene del link de web VER LISTA LIBROS, reenvia a web añadir libro
	@RequestMapping("/nuevoLibro")
	public String addBook(Model model) 
	{
		//En werb hay un combo con los autores. Rellenar combo
		model.addAttribute("comboAutores", serviceAutor.findAll());
		return "libros/webAddLibro.html";
	}
	
	//Muestra la web de insertar libro, donde tenemos la opcion introducir los datos del libro
	// guardar y volver a la web de LISTA LIBROS
	@RequestMapping("/insertarLibro")
	public String insertBook(Book libro, Model model) 
	{
		//libro.setEstado(EstadoLibro.DISPONIBLE);
		service.insertBook(libro);
		model.addAttribute("listalibros", service.findAll());
		
		return "libros/listadoLibros.html";
	}
	
	@RequestMapping(value = "/bajaLibro")
	public String removeBook(Model model, @RequestParam("libroId") Integer idLibro, HttpSession session) 
	{ 	
		List<Book> listaLibros = (List<Book>) session.getAttribute("listadoLibros");
		
		int index = this.exists(idLibro, listaLibros);
		
		if (index != -1)
		{
			Book libro = listaLibros.get(index);		
			service.deleteBook(libro);		
		}
		
		model.addAttribute("listalibros", service.findAll());
		
		return "libros/listadoLibros.html";
	}
	
	@RequestMapping(value = "/modificaLibro")
	public String modifyBook(Model model, @RequestParam("libroId") Integer idLibro, HttpSession session) 
	{ 	
		List<Book> listaLibros = (List<Book>) session.getAttribute("listadoLibros");
		
		int index = this.exists(idLibro, listaLibros);
		
		if (index != -1)
		{
			Book libro = listaLibros.get(index);
			
			model.addAttribute("libroModify", listaLibros.get(index)); 
					
			model.addAttribute("comboAutores", serviceAutor.findAll());
			return "libros/webModificarLibro.html";
		}
		return "libros/listadoLibros.html";
		
	}
	
	
	// metodos propios del controler
	private int exists(Integer idBookExiste, List<Book> listaLibros) 
	{
		for (int i = 0; i < listaLibros.size(); i++) 
		{
			if (listaLibros.get(i).getIdBook() == idBookExiste) 
			{
				return i;				
			}
		}
		return -1;
	}
}
