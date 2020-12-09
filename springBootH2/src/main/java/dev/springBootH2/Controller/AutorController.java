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
	public String showAutores(Model model, HttpSession sesion)
	{
		sesion.setAttribute("listadoAutores", serviceAutor.findAll());
		
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
		// En esta opción No se dan de alta los libros
		
		serviceAutor.insertAutor(autor);
		
		model.addAttribute("listaAutores", serviceAutor.findAll());
		return "autores/listadoAutores.html";
	}
	
	
	@RequestMapping(value = "/buscarAutor")
	public String buscaAutor(Model model, @RequestParam("autorNombre") String nombreAutor, HttpSession sesion)
	{
		
		List<Autor> listaAutores = serviceAutor.findByNombreAutor(nombreAutor);
		
		if (listaAutores.isEmpty())
		{
			model.addAttribute("listaAutores", serviceAutor.findAll());
		}
		else
		{
			model.addAttribute("listaAutores", listaAutores);
		}
		
		return "autores/listadoAutores.html";
	}
	
	
	
	@RequestMapping(value = "/modificaAutor")
	public String modifyAutor(@RequestParam("autorId") Long idAutor, Model model, HttpSession sesion) 
	{
		Optional<Autor> autorOptional = serviceAutor.findById(idAutor);
		
		if (autorOptional.isPresent())
		{
			model.addAttribute("autorParaModifcar", autorOptional.get()); 		
		
			return "autores/webModificarAutor.html";
		}	
		else
		{
			model.addAttribute("listaAutores", serviceAutor.findAll());
			return "autores/listadoAutores.html";
		}
	}
	
	@RequestMapping(value = "/updateAutor")
	public String updateBook(Autor autorAmodificar, Model model, HttpSession sesion) 
	{ 
		Optional<Autor> autorOptional = serviceAutor.findById(autorAmodificar.getIdAutor());
		
		if (autorOptional.isPresent())
			serviceAutor.updateAutor(autorAmodificar);
		else
			System.out.println("Mostrar No se ha podido modificar");					
						
		model.addAttribute("listaAutores", serviceAutor.findAll());
		return "autores/listadoAutores.html";
	}
}


