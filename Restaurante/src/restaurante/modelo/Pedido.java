package restaurante.modelo;

import java.util.ArrayList;

public abstract class Pedido {
	
//ATRIBUTOS
	private static int indice = 1;
	private int idPedido;
	private String fechaPedido;
	protected EstadoPedido estado;
	private Factura factura;
	private ArrayList <LineaPedido> lineasPedido;
	private Clientes cliente;
	
<<<<<<< HEAD
//CONSTRUCTOR - Añadi el ArrayList de lineasPedido
=======
	
	//Constructor
>>>>>>> main
	public Pedido(String fechaPedido, Clientes cliente) {
		idPedido = indice++;
		this.fechaPedido = fechaPedido;
		this.cliente = cliente;
		estado = EstadoPedido.Pendiente;
<<<<<<< HEAD
		this.lineasPedido = new ArrayList<>();  // ← IMPORTANTE: inicializar
=======
		lineasPedido = new ArrayList<>();
>>>>>>> main
	}
//METODOS GETTERS Y SETTERS
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
	
<<<<<<< HEAD
	
// GETTER FALTANTE (necesario para SistemaGestion k)
    public ArrayList<LineaPedido> getLineasPedido() {
        return lineasPedido;
    }
	
    
    
    
 // Método para obtener el siguiente ID de línea (útil para agregar platos k)
    public int getSiguienteIdLinea() {
        return lineasPedido.size() + 1;
    }  
        
        
	
 // MÉTODO CORREGIDO k
=======
	public ArrayList<LineaPedido> getLineasPedido() {
		return lineasPedido;
	}

>>>>>>> main
	public double calcularImporte() {
		int suma = 0;
		
		for (LineaPedido li : lineasPedido) {
<<<<<<< HEAD
			suma += li.getPrecioUnitario() * li.getCantidad();  // ← paréntesis y método corregido k
=======
			suma += li.calcularSubtotal();
>>>>>>> main
		}
		
		return suma;
	}
	
	
	
//METODOS DE LA PROPIA CLASE 	
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
