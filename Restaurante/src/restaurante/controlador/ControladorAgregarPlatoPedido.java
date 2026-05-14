package restaurante.controlador;

import restaurante.modelo.*;
import restaurante.vista.AgregarPlatoPedidoDialog;

public class ControladorAgregarPlatoPedido {
	private SistemaGestion sistemaGestion;
	private AgregarPlatoPedidoDialog vista;

	public ControladorAgregarPlatoPedido(SistemaGestion sistemaGestion, AgregarPlatoPedidoDialog vista) {
		this.sistemaGestion = sistemaGestion;
		this.vista = vista;
	}
	
	public void agregarPlato() {
		try {
			int idPedido = vista.getIdPedido();
			int idPlato = vista.getIdPlato();
			int cantidad = vista.getCantidad();
			String notas = vista.getNotas();
			
			// Buscamos el plato usando el método SistemaGestion
			Plato plato = sistemaGestion.buscarPlato(idPlato);
			
			if (plato == null) {
				vista.mostrarMensaje("No se ha encontrado ningún plato con el ID: " + idPlato);
				return;
			}
			
			if (cantidad <= 0) {
				vista.mostrarMensaje("La cantidad debe ser mayor que 0");
				return;
			}

			sistemaGestion.agregarPlatoAPedido(idPedido, plato, cantidad, notas);
			vista.mostrarMensaje("Plato agregado al pedido correctamente");
			vista.dispose();
			
		} catch (NumberFormatException e) {
			vista.mostrarMensaje("Los campos ID del Pedido, ID del Plato y Cantidad deben ser números enteros");
		}
	}
}