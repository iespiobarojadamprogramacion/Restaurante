package restaurante.modelo;

public class PedidoLlevar extends Pedido{
	private boolean recogidaEnLocal;
	private String direccionEntrega;
	
	public PedidoLlevar (String fechaPedido, boolean recogidaEnLocal, String direccionEntrega) {
		super(fechaPedido);
		this.recogidaEnLocal = recogidaEnLocal;
		
		this.direccionEntrega = recogidaEnLocal == false? direccionEntrega : null; 
	}
	
	public boolean isRecogidaEnLocal() {
		return recogidaEnLocal;
	}

	public String getDireccionEntrega() {
		return direccionEntrega;
	}

	public void marcarRecogido() {
		estado = EstadoPedido.Servido;
	}

	@Override
	public String toString() {
		return "PedidoLlevar [recogidaEnLocal=" + recogidaEnLocal + ", direccionEntrega=" + direccionEntrega
				+ ", estado=" + estado + ", getIdPedido()=" + getIdPedido() + ", getFechaPedido()=" + getFechaPedido()
				+ "]";
	}

}
