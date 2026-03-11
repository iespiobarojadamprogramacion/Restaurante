package restaurante.modelo;

public class PedidoSala extends Pedido {

	
	public PedidoSala(String fechaPedido) {
		super(fechaPedido);
	}

	@Override
	public String toString() {
		return "PedidoSala [getIdPedido()=" + getIdPedido() + ", getFechaPedido()=" + getFechaPedido()
				+ ", getEstado()=" + getEstado() + "]";
	}

}
