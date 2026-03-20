package restaurante.modelo;

public class LineaPedido {
   private int idLinea;
   private int cantidad;
   private double precioUnitario;
   private Plato plato;
   private String notas;
   private Pedido pedido;
 
   
   // Constructor
   public LineaPedido(int idLinea, int cantidad, Plato plato, String notas) {
       this.idLinea = idLinea;
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
       this.cantidad = nuevaCantidad;
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
