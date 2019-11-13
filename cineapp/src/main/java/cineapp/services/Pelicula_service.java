package cineapp.services;

import java.util.List;

import cineapp.model.Pelicula;

public interface Pelicula_service {
	
	public List<Pelicula> peliculas();
	
	public Pelicula buscarxid(int id);
	
	void insertar(Pelicula pelicula);
}
