package dev.springBootH2.Controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dev.springBootH2.Service.AutorService;
import dev.springBootH2.Service.BookService;
import dev.springBootH2.Service.CitaService;
import dev.springBootH2.Service.UsuarioService;

@Controller
public class HomeController 
{
	
	@Autowired
	AutorService serviceAutor;
	
	@Autowired
	BookService serviceBook;
	
	@Autowired
	CitaService serviceCita;

	@Autowired
	UsuarioService serviceUsuario;
	
	// @RequestMapping  o  @GetMapping
	@RequestMapping(value = { "/biblioteca" })	
	public String indice(Model model) 
	{
		model.addAttribute("mensaje", "Esta a punto de entrar en Biblioteca Mini ...");
		
		return "inicio/webHome.html";
	}

	@GetMapping("/*")
	public String webError() 
	{
		return "inicio/webError.html";
	}
	
	
	@GetMapping("/GestionUsuarios/verListadoUsuarios")
	public String gestionarUsuarios(Model model, HttpSession sesion) 
	{
		sesion.setAttribute("listadoUsuarios", serviceUsuario.findAll());		
		
		model.addAttribute("listaUsuarios", serviceUsuario.findAll());

		return "usuarios/listadoUsuarios.html";
	}
	
	
	@GetMapping("/GestionReservas/verListadoReservas")
	public String gestionarReservas() 
	{
		return "reservas/listadoReservas.html";
	}
	
	
	@GetMapping("/GestionLibros/verListadoLibros")
	public String gestionarLibros(Model model, HttpSession sesion) 
	{
		sesion.setAttribute("listadoLibros", serviceBook.findAll());
		model.addAttribute("listalibros", serviceBook.findAll());
		return "libros/listadoLibros.html";
	}

	
	@GetMapping("/GestionAutores/verListadoAutores")
	public String gestionarAutores(Model model, HttpSession sesion) 
	{
		sesion.setAttribute("listadoAutores", serviceAutor.findAll());
		model.addAttribute("listaAutores", serviceAutor.findAll());
		return "autores/listadoAutores.html";
	}
	

	@GetMapping("/GestionCitas/verListadoCitas")
	public String gestionarCitas(Model model, HttpSession sesion)
	{
		sesion.setAttribute("listadoCitas", serviceCita.findAll());
		model.addAttribute("listaCitas", serviceCita.findAll());
		return "citas/listadoCitas.html";
	}
		

}
