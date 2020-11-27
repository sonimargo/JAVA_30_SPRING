package dev.springBootH2.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import dev.springBootH2.Model.Autor;
import dev.springBootH2.Model.Book;
import dev.springBootH2.Service.AutorService;

@Controller
@RequestMapping("/GestionAutores")
public class AutorController 
{
	
	@Autowired
	AutorService service;
	
	@RequestMapping("/verListadoAutores")
	public String showAutores(Model model)
	{
		model.addAttribute("listaAutores", service.findAll());
		return "autores/listadoAutores.html";
	}
	
	@RequestMapping("/nuevoAutor")
	public String addAutor(Model model) 
	{
		return "autores/webAddAutor.html";
	}
	
	
	@RequestMapping("/insertarAutor")
	public String addAutor(Autor autor, Model model)
	{
		service.insertAutor(autor);
		
		model.addAttribute("listaAutores", service.findAll());
		return "autores/listadoAutores.html";
	}
}
