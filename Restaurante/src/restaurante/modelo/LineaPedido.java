package restaurante.modelo;

public class LineaPedido {
	private static int indice = 0;
	private int idLinea;
	private int cantidad;
	private double precioUnitario;
	private Plato plato;
	private String notas;
	private Pedido pedido;
 
	// Constructor
	public LineaPedido(int cantidad, Plato plato, String notas, Pedido pedido) {
		idLinea = indice++;
		this.cantidad = cantidad;
		this.plato = plato;
		this.precioUnitario = plato.getPrecioUnitario();
		this.notas = notas;
		this.pedido = pedido;
	}
	
	public double calcularSubtotal() {
		return this.precioUnitario * this.cantidad;
	}
	
	public void actualizarCantidad(int nuevaCantidad) {
		cantidad = nuevaCantidad;
	}
	
	public double getPrecioUnitario() {
		return precioUnitario;
	}
	
	public int getCantidad() {
		return cantidad;
	}
  
	public Plato getPlato() {
		return plato;
	}
}
