package restaurante.modelo;

public class PedidoSala extends Pedido {
	private Mesa mesa;
	
	public PedidoSala(String fechaPedido, Clientes cliente) {
		super(fechaPedido, cliente);
		this.mesa = asignarMesa(fechaPedido);
	}

	public Mesa getMesa() {
		return mesa;
	}
	
	//Automatiza el sistema de asignar mesa, buscando la mesa reservada en base a la fecha, más adelante se puede añadir una comprobación de hora tambien
	public Mesa asignarMesa (String fecha) {
		for (Reservas reserva : super.getCliente().getReservas()) {
			if (reserva.getFechaReserva().equals(fecha)) {
				reserva.getMesa().ocupar();
				return reserva.getMesa();
			}
		}
		return null;
	}
	
	public void liberarMesa() {
		mesa.liberar();
		mesa = null;
	}

	@Override
	public String toString() {
		return "PedidoSala [getIdPedido()=" + getIdPedido() + ", getFechaPedido()=" + getFechaPedido()
				+ ", getEstado()=" + getEstado() + "]";
	}

}
