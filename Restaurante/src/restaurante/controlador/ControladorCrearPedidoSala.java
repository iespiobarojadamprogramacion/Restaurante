package restaurante.controlador;

import restaurante.modelo.*;
import restaurante.vista.CrearPedidoSalaDialog;

public class ControladorCrearPedidoSala {
	private SistemaGestion sistemaGestion;
	private CrearPedidoSalaDialog vista;

	public ControladorCrearPedidoSala(SistemaGestion sistemaGestion, CrearPedidoSalaDialog vista) {
		this.sistemaGestion = sistemaGestion;
		this.vista = vista;
	}
	
	public void crearPedido() {
		Clientes cliente = vista.getCliente();
		String fecha = vista.getFecha();
		
		if (cliente == null) {
			vista.mostrarMensaje("Debe seleccionar un cliente");
			return;
		}
		
		if (!ControladorFechas.esFechaValida(fecha)) {
			vista.mostrarMensaje("La fecha no es válida");
			return;
		}
		sistemaGestion.crearPedidoSala(cliente, fecha);
		
		vista.mostrarMensaje("Pedido en sala creado correctamente");
		vista.dispose();
	}
}