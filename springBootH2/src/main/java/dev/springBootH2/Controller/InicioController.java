package dev.springBootH2.Controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InicioController 
{
	@RequestMapping(value = { "/biblioteca" })	
	public String inicioHome(Locale locale,Model model) 
	{
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		
		//Para el objeto model, creamos atributo serverTime con la fecha del servidor, en formato String
		//Con este objeto model se trabaja con Thymeleaf en la web.html 
		model.addAttribute("serverTime", formattedDate);
		model.addAttribute("mensaje", "Esta a punto de entrar en Biblioteca Mini ...");
		
		return "inicio/webHome.html";
	}

	@RequestMapping(value = { "/*" })	
	public String paginaError(Locale locale,Model model) 
	{
		/*
		 * Date date = new Date(); DateFormat dateFormat =
		 * DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		 * String formattedDate = dateFormat.format(date);
		 * 
		 * //Para el objeto model, creamos atributo serverTime con la fecha del
		 * servidor, en formato String //Con este objeto model se trabaja con Thymeleaf
		 * en la web.html model.addAttribute("serverTime", formattedDate);
		 * model.addAttribute("mensaje",
		 * "Esta a punto de entrar en Biblioteca Mini ...");
		 */
		
		return "inicio/webError.html";
	}

}
