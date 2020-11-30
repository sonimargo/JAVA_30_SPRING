package dev.springBootH2.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import dev.springBootH2.Service.AutorService;
import dev.springBootH2.Service.CitaService;

@Controller
@RequestMapping("/GestionCitas")
public class CitasController 
{

	@Autowired
	AutorService serviceAutor;

	@Autowired
	CitaService serviceCita;
	
	
}
