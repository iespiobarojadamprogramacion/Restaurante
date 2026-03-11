package restaurante.modelo;

public abstract class Pedido {
	private static int indice = 1;
	private int idPedido;
	private String fechaPedido;
	protected EstadoPedido estado;
	
	public Pedido(String fechaPedido) {
		idPedido = indice++;
		this.fechaPedido = fechaPedido;
		estado = EstadoPedido.Pendiente;
	}
	
	public int getIdPedido() {
		return idPedido;
	}

	public String getFechaPedido() {
		return fechaPedido;
	}

	public EstadoPedido getEstado() {
		return estado;
	}
	
	public void cambiarEstado(EstadoPedido nuevoEstado) {
		estado = nuevoEstado;
	}

	@Override
	public String toString() {
		return "Pedido [idPedido=" + idPedido + ", fechaPedido=" + fechaPedido + ", estado=" + estado + "]";
	}
	
	

}
