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
import dev.springBootH2.Utilitats.EstadoLibro;

@Controller
@RequestMapping("/GestionLibros")
public class BookController {

	@Autowired
	BookService serviceBook;
	
	@Autowired
	AutorService serviceAutor;

	
	@RequestMapping("/inicio")
	public String inicio(Model model) 
	{
		return "inicio/webHome.html";
	}
	
	@RequestMapping("/verListadoLibros")
	public String showBooks(Model model, HttpSession sesion) 
	{
		sesion.setAttribute("listadoLibros", serviceBook.findAll());		
			
		model.addAttribute("listalibros", serviceBook.findAll());
		
		return "libros/listadoLibros.html";
	}

	//Viene del link de web VER LISTA LIBROS, reenvia a web añadir libro
	@RequestMapping("/nuevoLibro")
	public String addBook(Model model) 
	{
		//En web hay un combo con los autores. Rellenar combo
		model.addAttribute("listaAutores", serviceAutor.findAll());
		return "libros/webAddLibro.html";
	}
	
	//Muestra la web de insertar libro, donde tenemos la opcion introducir los datos del libro
	// guardar y volver a la web de LISTA LIBROS
	@RequestMapping("/insertarLibro")
	public String insertBook(Book libro, @RequestParam("autorId") Long idAutor, Model model, HttpSession sesion) 
	{
		Optional<Autor> AutorOptional = serviceAutor.findById(idAutor);
		
		if (AutorOptional.isPresent())
		{
			libro.setEstado(EstadoLibro.DISPONIBLE);
			libro.setAutor(AutorOptional.get());
			
			serviceBook.insertBook(libro);				
		}
		
		sesion.setAttribute("listadoLibros", serviceBook.findAll());
		
		model.addAttribute("listalibros", serviceBook.findAll());
		
		return "libros/listadoLibros.html";
		
	}
	
	
	@RequestMapping(value = "/altaLibro")
	public String altaBook(Model model, @RequestParam("libroId") Long idLibro, HttpSession sesion) 
	{ 	
		List<Book> listaLibros = (List<Book>) sesion.getAttribute("listadoLibros");
		
		int index = this.exists(idLibro, listaLibros);
		
		if (index != -1)
		{
			Book libro = listaLibros.get(index);
			libro.setEstado(EstadoLibro.DISPONIBLE);
			serviceBook.updateBook(libro);
		}
		
		model.addAttribute("listalibros", serviceBook.findAll());
		
		return "libros/listadoLibros.html";
	}
	
	
	@RequestMapping(value = "/bajaLibro")
	public String removeBook(Model model, @RequestParam("libroId") Long idLibro, HttpSession sesion) 
	{ 	
		List<Book> listaLibros = (List<Book>) sesion.getAttribute("listadoLibros");
		
		int index = this.exists(idLibro, listaLibros);
		
		if (index != -1)
		{
			Book libro = listaLibros.get(index);
			libro.setEstado(EstadoLibro.BAJA);
			//service.deleteBook(libro);
			serviceBook.updateBook(libro);
		}
		
		model.addAttribute("listalibros", serviceBook.findAll());
		
		return "libros/listadoLibros.html";
	}
	
	
	@RequestMapping(value = "/buscarLibro")
	public String buscaBook(Model model, @RequestParam("libroTitulo") String tituloLibro, HttpSession sesion) 
	{ 
		List<Book> listaLibros = serviceBook.findByTituloLibro(tituloLibro);
		
		if (listaLibros.isEmpty())
		{
			model.addAttribute("listalibros", serviceBook.findAll());	
		}	
		else
		{
			model.addAttribute("listalibros", listaLibros);
		}
		
		
		
		return "libros/listadoLibros.html";
		
	}
	
	//Metodo que nos llevará a la web de modificar, con los datos del libro
	@RequestMapping(value = "/modificaLibro")
	public String modifyBook(@RequestParam("libroId") Long idLibro, Model model, HttpSession sesion) 
	{ 			
		Optional<Book> libroOptional = serviceBook.findById(idLibro);
		
		if (libroOptional.isPresent())
		{			
			model.addAttribute("libroParaModifcar", libroOptional.get());
			
			if ((libroOptional.get().getAutor()) == null)
			{
				model.addAttribute("autor", 0);
			}
			else
			{
				model.addAttribute("autor", libroOptional.get().getAutor());
			}
			
			model.addAttribute("listaAutores", serviceAutor.findAll());
			return "libros/webModificarLibro.html";
		}
		else
		{
			model.addAttribute("listalibros", serviceBook.findAll());			
			return "libros/listadoLibros.html";			
		}

		
	}

	
	@RequestMapping(value = "/updateLibro")
	public String updateBook(Book libroAmodificar, Model model, HttpSession sesion, @RequestParam("autorId") Long idAutor) 
	{ 
		Optional<Autor> autorOptional = serviceAutor.findById(idAutor);
		
		//Optional<Book> bookOptional = serviceBook.findById(libroAmodificar.getIdBook());
		
		if (autorOptional.isPresent())
			libroAmodificar.setAutor(autorOptional.get());
		else
			libroAmodificar.setAutor(null);
					
		serviceBook.updateBook(libroAmodificar);
				
		model.addAttribute("listalibros", serviceBook.findAll());
		
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
	private int exists(Long idBookExiste, List<Book> listaLibros) 
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
