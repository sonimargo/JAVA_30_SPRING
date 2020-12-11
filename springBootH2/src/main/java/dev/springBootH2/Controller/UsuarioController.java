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
import dev.springBootH2.Model.Usuario;
import dev.springBootH2.Service.UsuarioService;
import dev.springBootH2.Utilitats.EstadoLibro;
import dev.springBootH2.Utilitats.EstadoUsuario;

@Controller
@RequestMapping("/GestionUsuarios")
public class UsuarioController 
{
	@Autowired
	UsuarioService serviceUsuario;
	
	@RequestMapping("/inicio")
	public String inicioDeUsuario(Model model) 
	{
		return "redirect: inicio/webHome.html";
	}
	
	@RequestMapping("/verListadoUsuarios")
	public String showBooks(Model model, HttpSession sesion) 
	{
		sesion.setAttribute("listadoUsuarios", serviceUsuario.findAll());		
			
		model.addAttribute("listaUsuarios", serviceUsuario.findAll());
		
		return "usuarios/listadoUsuarios.html";
	}
	
	@RequestMapping("/nuevoUsuario")
	public String addUsuario(Model model) 
	{
		//En web hay un combo con los autores. Rellenar combo
		model.addAttribute("listaUsuarios", serviceUsuario.findAll());
		return "usuarios/webAddUsuario.html";
	}
	
	@RequestMapping("/insertarUsuario")
	public String insertUsuario(Usuario usuario, Model model, HttpSession sesion) 
	{		
		usuario.setEstado(EstadoUsuario.ACTIVO);
		
		System.out.println("******************************************" + usuario.toString());
		serviceUsuario.insertUsuario(usuario);
				
		sesion.setAttribute("listadoUsuarios", serviceUsuario.findAll());		
		
		model.addAttribute("listaUsuarios", serviceUsuario.findAll());
		
		return "usuarios/listadoUsuarios.html";

		
	}
}
