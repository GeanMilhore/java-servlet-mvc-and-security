package br.com.alura.gerenciador.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;

public class DateUtil {
	
	private static String INPUT_FORMAT = "yyyy-MM-dd";

	public static Date parseDateFromString(String dataEmpresa) throws ServletException {
		Date dataAbertura;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(INPUT_FORMAT);
			dataAbertura = sdf.parse(dataEmpresa);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		return dataAbertura;
	}
	
	public static String dateFromStringInput(Date data) throws ServletException {
		String dataFormatada;
		SimpleDateFormat sdf = new SimpleDateFormat(INPUT_FORMAT);
		dataFormatada = sdf.format(data);
		return dataFormatada;
	}
}
