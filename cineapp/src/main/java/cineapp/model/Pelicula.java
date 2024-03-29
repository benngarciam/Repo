package cineapp.model;

import java.util.Date;

public class Pelicula {
	
	private int id;
	private String titulo;
	private int duracion;
	private String clasificacion;
	private String genero;
	private String imagen;
	private Date fecha_Estreno;
	private String estatus;
	
	public Pelicula()
	{
		id = 0;
		titulo = "";
		duracion = 0;
		clasificacion = "";
		genero = "";
		imagen = "";
		fecha_Estreno = new Date();
		estatus = "";
	}
	
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	public String getTitulo()
	{
		return titulo;
	}
	public void setTitulo(String titulo)
	{
		this.titulo = titulo;
	}
	public int getDuracion()
	{
		return duracion;
	}
	public void setDuracion(int duracion)
	{
		this.duracion = duracion;
	}
	public String getClasificacion()
	{
		return clasificacion;
	}
	public void setClasificacion(String clasificacion)
	{
		this.clasificacion = clasificacion;
	}
	public String getGenero()
	{
		return genero;
	}
	public void setGenero(String genero)
	{
		this.genero = genero;
	}
	public String getImagen()
	{
		return imagen;
	}
	public void setImagen(String imagen)
	{
		this.imagen = imagen;
	}
	public Date getFecha_Estreno()
	{
		return fecha_Estreno;
	}
	public void setFecha_Estreno(Date fecha_Estreno)
	{
		this.fecha_Estreno = fecha_Estreno;
	}
	public String getEstatus()
	{
		return estatus;
	}
	public void setEstatus(String estatus)
	{
		this.estatus = estatus;
	}
	
	@Override
	public String toString()
	{
		return "pelicula[id = "+id+
				", titulo = "+titulo+
				", duracion = "+duracion+
				", clasificacion = "+clasificacion+
				", genero = "+genero+
				", imagen ="+imagen+
				", Fecha_Estreno = "+fecha_Estreno+
				", estatus = "+estatus+"]";
	}
}
