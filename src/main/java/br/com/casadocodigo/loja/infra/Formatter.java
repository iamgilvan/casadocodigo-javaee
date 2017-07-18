package br.com.casadocodigo.loja.infra;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Formatter {
	
	private SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
	
	public String dateFormat(Calendar calendar){
		return dateFormatter.format(calendar.getTime());
	}

}
