package restaurante.controlador;

import restaurante.modelo.*;
import restaurante.vista.ConfirmarReservaDialog;

public class ControladorConfirmarReserva {
	private SistemaGestion sistemaGestion;
	private ConfirmarReservaDialog vista;
	
	public ControladorConfirmarReserva(SistemaGestion sistemaGestion, ConfirmarReservaDialog vista) {
		this.sistemaGestion = sistemaGestion;
		this.vista = vista;
	}
	
	public void confirmar() {
		Reservas r = vista.getReservaSeleccionada();
		
		if (r == null) {
			vista.mostrarMensaje("Deve seleccionar una reserva");
			return;
		}
		
		sistemaGestion.confirmarReserva(r.getIdReserva());
		vista.mostrarMensaje("Reserva confirmada");
		vista.dispose();
	}

}
