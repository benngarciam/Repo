package cineapp.util;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;


public class Utilerias {
	
	public static List<String> genera_fechas(int cantidad)
	{
		SimpleDateFormat ffecha= new SimpleDateFormat("dd-MM-yyyy");
		
		Date fecha_actual = new Date();
		Calendar calendario = Calendar.getInstance();
		calendario.add(Calendar.DAY_OF_MONTH, cantidad);
		Date ultima_fecha = calendario.getTime();
		
		GregorianCalendar gregorian_calendar = new GregorianCalendar();
		gregorian_calendar.setTime(fecha_actual);
		
		ArrayList<String> arreglo_fechas = new ArrayList<String>();
		
		while (!gregorian_calendar.getTime().after(ultima_fecha)) {
		
			Date fecha = gregorian_calendar.getTime();
			gregorian_calendar.add(Calendar.DATE, 1);
			arreglo_fechas.add(ffecha.format(fecha));
		}
		
		return arreglo_fechas;
	}
}
