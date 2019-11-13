package cineapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Detalle_controller {
	
	@RequestMapping(value = "/detalle", method = RequestMethod.GET)
	public String goDetalle()
	{
		return "detalle";
	}

}
