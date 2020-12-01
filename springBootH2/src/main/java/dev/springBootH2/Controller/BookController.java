package dev.springBootH2.Controller;

import java.util.List;
import java.util.Optional;

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
	public String insertBook(Book libro, Model model, HttpSession sesion) 
	{
		libro.setEstado(EstadoLibro.DISPONIBLE);
		service.insertBook(libro);		
		
		sesion.setAttribute("listadoLibros", service.findAll());		
		
		model.addAttribute("listalibros", service.findAll());
		
		return "libros/listadoLibros.html";
	}
	
	@RequestMapping(value = "/bajaLibro")
	public String removeBook(Model model, @RequestParam("libroId") Integer idLibro, HttpSession sesion) 
	{ 	
		List<Book> listaLibros = (List<Book>) sesion.getAttribute("listadoLibros");
		
		int index = this.exists(idLibro, listaLibros);
		
		if (index != -1)
		{
			Book libro = listaLibros.get(index);
			libro.setEstado(EstadoLibro.BAJA);
			//service.deleteBook(libro);
			service.updateBook(libro);
		}
		
		model.addAttribute("listalibros", service.findAll());
		
		return "libros/listadoLibros.html";
	}
	
	@RequestMapping(value = "/modificaLibro")
	public String modifyBook(Model model, @RequestParam("libroId") Integer idLibro, HttpSession sesion) 
	{ 	
		System.out.println("********************************************************************" + idLibro);
		List<Book> listaLibros = (List<Book>) sesion.getAttribute("listadoLibros");
		
		int index = this.exists(idLibro, listaLibros);
		
		if (index != -1)
		{
			Book libro = listaLibros.get(index);
			
			System.out.println("********************************************************************" + libro.toString());
			model.addAttribute("libroModify", listaLibros.get(index)); 
			
			System.out.println("******************************************************************** despues model libro" );
			model.addAttribute("comboAutores", serviceAutor.findAll());
			System.out.println("******************************************************************** despues model combo autores" );
			return "libros/webModificarLibro.html";
		} 
		else
		{
			//Si el id de libro no existe, retorno a la lista de libros 
			sesion.setAttribute("listadoLibros", service.findAll());		
			
			model.addAttribute("listalibros", service.findAll());
			return "libros/listadoLibros.html";	
		}
	}

	
	@RequestMapping(value = "/updateLibro")
	public String updateBook(Book libroAmodificar, Model model, HttpSession sesion) 
	{ 
		System.out.println("********************************************************************");
		System.out.println("********************************************************************" + libroAmodificar.toString());

		
		
		Optional<Book> bookOptional = service.findById(libroAmodificar.getIdBook());
		
		if (bookOptional.isPresent());
		{
			service.updateBook(libroAmodificar);
		}
		
		sesion.setAttribute("listadoLibros", service.findAll());
		
		model.addAttribute("listalibros", service.findAll());
		
		return "libros/listadoLibros.html";
		
		
		//System.out.println("******************************************************************* libro id " + libro.idBook);
		
		//List<Book> listaLibros = (List<Book>) sesion.getAttribute("listadoLibros");
		
		
		
		//repository.findById(title);
		
		//int index = this.exists(idLibro, listaLibros);
		
	//	if (index != -1) // Exite 
	//	{
		//	System.out.println("******************************************************************* libro inex " + index);
		//	service.saveBook(libroAmodificar);
	//	}
		
		//sesion.setAttribute("listadoLibros", service.findAll());		
		
		//model.addAttribute("listalibros", service.findAll());//
		
		
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
