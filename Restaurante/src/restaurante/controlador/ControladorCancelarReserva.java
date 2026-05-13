package restaurante.controlador;

import restaurante.modelo.*;
import restaurante.vista.CancelarReservaDialog;

public class ControladorCancelarReserva {
	private SistemaGestion sistemaGestion;
	private CancelarReservaDialog vista;
	
	public ControladorCancelarReserva(SistemaGestion sistemaGestion, CancelarReservaDialog vista) {
		this.sistemaGestion = sistemaGestion;
		this.vista = vista;
	}
	
	public void confirmar() {
		Reservas r = vista.getReservaSeleccionada();
		
		if (r == null) {
			vista.mostrarMensaje("Deve seleccionar una reserva");
			return;
		}
		
		sistemaGestion.cancelarReserva(r.getIdReserva());
		vista.mostrarMensaje("Reserva cancelada");
		vista.dispose();
	}

}
