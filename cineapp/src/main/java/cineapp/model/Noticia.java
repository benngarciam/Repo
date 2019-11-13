package cineapp.model;

import java.util.Date;

public class Noticia {

	private int id;
	private String titulo;
	private Date fechaNoticia;
	private String detalle;
	private String estatus;
	
	public Noticia() {
		id = 0;
		titulo = "";
		fechaNoticia = new Date();
		detalle = "";
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
	public Date getFechaNoticia()
	{
		return fechaNoticia;
	}
	public void setFechaNoticia(Date fechaNoticia)
	{
		this.fechaNoticia = fechaNoticia;
	}
	public String getDetalle()
	{
		return detalle;
	}
	public void setDetalle(String detalle)
	{
		this.detalle = detalle;
	}
	public String getEstatus()
	{
		return estatus;
	}
	public void setEstatus(String estatus)
	{
		this.estatus = estatus;
	}
	
	public String toString()
	{
		return "Noticia[id = " + id +
				", titulo = "+ titulo +
				", fechaNoticia =" + fechaNoticia +
				", detalle = "+ detalle +
				", estatus = "+ estatus +"]";
	}
}
