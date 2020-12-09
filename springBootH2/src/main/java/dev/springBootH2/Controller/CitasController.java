package dev.springBootH2.Controller;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import dev.springBootH2.Model.Autor;
import dev.springBootH2.Model.Book;
import dev.springBootH2.Model.Cita;
import dev.springBootH2.Service.AutorService;
import dev.springBootH2.Service.CitaService;
import dev.springBootH2.Utilitats.EstadoLibro;

@Controller
@RequestMapping("/GestionCitas")
public class CitasController 
{

	@Autowired
	CitaService serviceCita;
	
	@Autowired
	AutorService serviceAutor;

	
	@RequestMapping("/inicio")
	public String inicio(Model model) 
	{
		return "inicio/webHome.html";
	}
	
	@RequestMapping("/verListadoCitas")
	public String showCitas(Model model)
	{
		model.addAttribute("listaCitas", serviceCita.findAll());
		
		return "citas/listadoCitas.html";
	}
	
	@RequestMapping("/nuevaCita")
	public String addCita(Model model) 
	{
		model.addAttribute("listaAutores", serviceAutor.findAll());
		return "citas/webAddCita.html";
	}
	
	@RequestMapping("/insertarCita")
	public String insertCita(Cita cita, @RequestParam("autorId") Long idAutor, Model model, HttpSession sesion) 
	{
		Optional<Autor> AutorOptional = serviceAutor.findById(idAutor);
		
		System.out.println("****************************************************************");
		if (AutorOptional.isPresent())
		{
			cita.setAutor(AutorOptional.get());
			
			serviceCita.insertCita(cita);
		}
		
		sesion.setAttribute("listadoCitas", serviceCita.findAll());		
		
		model.addAttribute("listaCitas", serviceAutor.findAll());
		
		return "citas/listadoCitas.html";
	}
}












