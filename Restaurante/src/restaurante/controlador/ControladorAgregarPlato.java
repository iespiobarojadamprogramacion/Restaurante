package restaurante.controlador;

import restaurante.modelo.*;
import restaurante.vista.AgregarPlatoAPedidoDialog;

public class ControladorAgregarPlato {
	private SistemaGestion sistemaGestion;
	private AgregarPlatoAPedidoDialog vista;
	
	public ControladorAgregarPlato (SistemaGestion sistemaGestion, AgregarPlatoAPedidoDialog vista) {
		this.sistemaGestion = sistemaGestion;
		this.vista = vista;
	}
	
	public void agregarPlato() {
		Pedido pedido = vista.getPedidoSeleccionado();
		Plato plato = vista.getPlatoSeleccionado();
		int cantidad = vista.getCantidad();
		String notas = vista.getNotas();
		
		if (pedido == null) {
            vista.mostrarMensaje("Debe seleccionar un pedido");
            return;
        }

        if (plato == null) {
            vista.mostrarMensaje("Debe seleccionar un plato");
            return;
        }

        if (cantidad <= 0) {
            vista.mostrarMensaje("La cantidad debe ser mayor que 0");
            return;
        }

        sistemaGestion.agregarPlatoAPedido(pedido.getIdPedido(), plato, cantidad, notas);

        vista.mostrarMensaje("Plato añadido correctamente");
        vista.dispose();
	}

}
