package cineapp.services;

import java.text.SimpleDateFormat;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import cineapp.model.Pelicula;

@Service
public class Pelicula_service_impl implements Pelicula_service {

	SimpleDateFormat ffecha = new SimpleDateFormat("dd-MM-yyyy");
	
	private List<Pelicula> peliculas = null;
	
	public Pelicula_service_impl() {
		try {
			
			peliculas = new LinkedList<Pelicula>();
			
			Pelicula pelicula0 = new Pelicula();
			pelicula0.setId(0);
			pelicula0.setTitulo("Avengers I");
			pelicula0.setDuracion(120);
			pelicula0.setClasificacion("A");
			pelicula0.setGenero("Acción");
			pelicula0.setImagen("avengers1.jpg");
			pelicula0.setFecha_Estreno(ffecha.parse("13-03-1986"));
			pelicula0.setEstatus("Activa");
			
			Pelicula pelicula1 = new Pelicula();
			pelicula1.setId(1);
			pelicula1.setTitulo("Avengers II");
			pelicula1.setDuracion(120);
			pelicula1.setClasificacion("B");
			pelicula1.setGenero("Drama");
			pelicula1.setImagen("avengers2.jpg");
			pelicula1.setFecha_Estreno(ffecha.parse("13-03-1986"));
			pelicula1.setEstatus("Inactiva");
			
			peliculas.add(pelicula0);
			peliculas.add(pelicula1);
			
		} catch (Exception e) {
			System.out.println("Error en curso:" + e.getMessage());
		}
	}

	@Override
	public void insertar(Pelicula pelicula) {
		peliculas.add(pelicula);
	}

	@Override
	public Pelicula buscarxid(int id) {
		
		for(Pelicula p: peliculas())
		{
			if(p.getId() == id)
			{
				return p;
			}
		}
		
		return null;
	}

	@Override
	public List<Pelicula> peliculas() {
		// TODO Auto-generated method stub
		return peliculas;
	}
}