package restaurante.modelo;

public class PedidoSala extends Pedido {
	private Mesa mesa;
	
	public PedidoSala(String fechaPedido, Clientes cliente) {
		super(fechaPedido, cliente);
	}

	public Mesa getMesa() {
		return mesa;
	}
	
	public void asignarMesa (Mesa mesa) {
		this.mesa = mesa;
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
