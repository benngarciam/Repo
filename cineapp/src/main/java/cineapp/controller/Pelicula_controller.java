package cineapp.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cineapp.model.Pelicula;
import cineapp.services.Pelicula_service;

@Controller
@RequestMapping(value = "/pelicula")
public class Pelicula_controller {
	
	@InitBinder
	public void formatofecha(WebDataBinder binder)
	{
		SimpleDateFormat ffecha = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(ffecha, false));
	}

	@Autowired
	private Pelicula_service pelicula_service;
	
	@GetMapping(value = "/lista_pelis")
	public String mostrar_index(Model model)
	{
		List<Pelicula> lista_pelis = pelicula_service.peliculas();
		model.addAttribute("peliculas", lista_pelis);
		
		return "pelicula/lista_peliculas";
	}
	
	@GetMapping(value = "/crear")
	public String goPelicula()
	{
		return "pelicula/formPelicula";
	}
	
	@PostMapping(value = "/guardar")
	public String crearPelicula(Pelicula pelicula, BindingResult result, RedirectAttributes attribute)
	{
		
		System.out.println("Recibiendo objeto pelicula: " + pelicula);
		System.out.println("Peliculas antes de guardar nuevo: " + pelicula_service.peliculas().size());
		
		pelicula_service.insertar(pelicula);
		
		System.out.println("Peliculas despues de guardar nuevo: " + pelicula_service.peliculas().size());
		
		//Mostramos errores en consola
		/*if(result.hasErrors())
		{
			System.out.println("Tenemos errores:...");
		}*/
		
		for(ObjectError error: result.getAllErrors())
		{
			System.out.println("..." + error.getDefaultMessage());
		}
		//-----------------------------------
		
		attribute.addFlashAttribute("mensaje", "La pelicula ha sido guardada");
		
		//return "pelicula/formPelicula";
		return "redirect:/pelicula/lista_pelis";
	}
	
	@GetMapping(value = "/formPelicula")
	public String goformPelicula()
	{
		return "pelicula/formPelicula";
	}
}
