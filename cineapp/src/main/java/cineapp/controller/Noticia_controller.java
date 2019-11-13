package cineapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import cineapp.model.Noticia;
import cineapp.services.Noticia_service;

@Controller
@RequestMapping(value = "/noticia")
public class Noticia_controller {
	
	@Autowired
	private Noticia_service noticia_service;
	
	@GetMapping(value = "/crear")
	public String crearNoticia()
	{
		return "noticia/formNoticia";
	}
	
	@PostMapping(value = "/guardar")
	public String guadraNoticia(Model model,
								//@RequestParam("id")int id,
								@RequestParam("titulo")String titulo,
								//@RequestParam("fechaNoticia")Date fechaNoticia,
								@RequestParam("detalle")String detalle,
								@RequestParam("estatus")String estatus)
	{
		List<Noticia> noticias = new ArrayList<Noticia>();

		Noticia noticia = new Noticia();
		//noticia.setId(id);
		noticia.setTitulo(titulo);
		//noticia.setFechaNoticia(fechaNoticia);
		noticia.setDetalle(detalle);
		noticia.setEstatus(estatus);
		
		noticias.add(noticia);
		
		model.addAttribute("noti", noticia);
		
		noticia_service.guardarNoticia(noticia);
		
		return "noticia/formNoticia";
	}
}