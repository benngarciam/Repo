package cineapp.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cineapp.model.Pelicula;
import cineapp.services.Pelicula_service;
import cineapp.util.Utilerias;

@Controller
public class Home_controller {

	@Autowired
	private Pelicula_service pelicula_service;
	
	SimpleDateFormat ffecha =  new SimpleDateFormat("dd-MM-yyyy");
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String goHome(Model model)
	{
		List<Pelicula> peliculas = pelicula_service.peliculas();
		model.addAttribute("peliculas", peliculas);
		
		List<String> fechas = Utilerias.genera_fechas(5);
		model.addAttribute("fechas", fechas);
		
		model.addAttribute("fecha_actual", ffecha.format(new Date()) );
		
		return "home";
	}

	@RequestMapping(value = "/buscar_fecha", method = RequestMethod.POST)
	public String buscarFecha(Model model, @RequestParam("fecha")String fecha)
	{
		List<Pelicula> peliculas  =  pelicula_service.peliculas();
		model.addAttribute("peliculas", peliculas);
		
		List<String> fechas = Utilerias.genera_fechas(5);
		model.addAttribute("fechas", fechas);
		
		model.addAttribute("fecha_actual", fecha);
		
		return "home";
	}
	
	@RequestMapping(value = "/detalle/{id}/{fecha_actual}", method = RequestMethod.GET)
	public String goDetalle(Model model, @PathVariable("id")int id_pelicula, @PathVariable("fecha_actual")String fecha_actual)
	{
		model.addAttribute("pelicula", pelicula_service.buscarxid(id_pelicula));
		
		return "detalle";
	}
}