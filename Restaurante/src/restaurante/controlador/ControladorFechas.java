package restaurante.controlador;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

public class ControladorFechas {
	private static final DateTimeFormatter FORMATO =
			DateTimeFormatter.ofPattern("dd/MM/uuuu")
			.withResolverStyle(ResolverStyle.STRICT);

	public static boolean esFechaValida(String fecha) {
		try {
			LocalDate.parse(fecha, FORMATO);
			return true;
		} catch (DateTimeParseException e) {
			return false;
		}
	}
}
