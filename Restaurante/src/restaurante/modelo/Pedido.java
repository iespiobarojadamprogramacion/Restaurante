package restaurante.modelo;

import java.util.ArrayList;

public abstract class Pedido {
	private static int indice = 1;
	private int idPedido;
	private String fechaPedido;
	protected EstadoPedido estado;
	private Factura factura;
	private ArrayList <LineaPedido> lineasPedido;
	private Clientes cliente;
	
	
	//Constructor
	public Pedido(String fechaPedido, Clientes cliente) {
		idPedido = indice++;
		this.fechaPedido = fechaPedido;
		this.cliente = cliente;
		estado = EstadoPedido.Pendiente;
		lineasPedido = new ArrayList<>();
	}
	
	public int getIdPedido() {
		return idPedido;
	}

	public String getFechaPedido() {
		return fechaPedido;
	}

	public Factura getFactura() {
		return factura;
	}

	public Clientes getCliente() {
		return cliente;
	}

	public EstadoPedido getEstado() {
		return estado;
	}
	
	public ArrayList<LineaPedido> getLineasPedido() {
		return lineasPedido;
	}

	public double calcularImporte() {
		int suma = 0;
		
		for (LineaPedido li : lineasPedido) {
			suma += li.calcularSubtotal();
		}
		
		return suma;
	}
	
	public void cambiarEstado(EstadoPedido nuevoEstado) {
		estado = nuevoEstado;
	}
	
	public void agregarLinea(LineaPedido lineaPedido) {
		lineasPedido.add(lineaPedido);
	}
	
	public void eliminarLinea(LineaPedido lineaPedido) {
		lineasPedido.remove(lineaPedido);
	}

	@Override
	public String toString() {
		return "Pedido [idPedido=" + idPedido + ", fechaPedido=" + fechaPedido + ", estado=" + estado + "]";
	}
	
	

}
