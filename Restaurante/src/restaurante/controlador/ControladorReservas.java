package restaurante.controlador;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import restaurante.modelo.*;
import restaurante.vista.CrearReservaDialog;

public class ControladorReservas {
	private SistemaGestion sistemaGestion;
	private CrearReservaDialog vista;

	public ControladorReservas(SistemaGestion sistemaGestion, CrearReservaDialog vista) {
		this.sistemaGestion = sistemaGestion;
		this.vista = vista;
	}
	
	public void crearReserva() {
		Clientes cliente = vista.getCliente();
		String fecha = vista.getFecha();
		String hora = vista.getHora();
		int comensales;
		
		try {
			comensales = vista.getComensale();
		} catch (NumberFormatException e) {
			vista.mostrarError("El número de coemsanles debe ser un número entero");
			return;
		}
		
		if (cliente == null) {
			vista.mostrarError("Debe seleccionar un cliente");
			return;
		}
		
		if (!ControladorFechas.esFechaValida(fecha)) {
			vista.mostrarError("La fecha no es valida");
			return;
		}
		
		if (!esHoraValida(hora)) {
			vista.mostrarError("La hora no es válida");
			return;
		}
		
		Mesa mesa = sistemaGestion.buscarMesa(comensales, fecha, hora);
		
		if (mesa == null) {
			vista.mostrarError("No hay mesas disponibles para esa fecha y hora");
			return;
		}
		
		Reservas reserva = new Reservas(fecha, hora, comensales, mesa, cliente);
		sistemaGestion.crearReserva(reserva);
		
		vista.mostrarError("Reserva creada correctamente");
		vista.dispose();
	}
	
	private boolean esHoraValida (String hora) {
		try {
			LocalTime.parse(hora, DateTimeFormatter.ofPattern("HH:mm"));
			return true;
		} catch (DateTimeParseException e) {
			return false;
		}
	}
}
