package restaurante.modelo;

public class LineaPedido {
   private int idLinea;
   private int cantidad;
   private double precioUnitario;
   private Plato plato;
   private String notas;
   private Pedido pedido;
 
   
  
// Constructor - Añadi el parametro Pedido pedido
   public LineaPedido(int idLinea, int cantidad, Plato plato, String notas, Pedido pedido) {
       this.idLinea = idLinea;
       this.cantidad = cantidad;
       this.plato = plato;
       this.precioUnitario = plato.getPrecioUnitario();
       this.notas = notas;
       this.pedido = pedido;
   }
 

   
 //IMPLEMENTADO POR K PARA QUE FUNCIONE LA APP- MODIFIQUE CONSTRUCTOR Y AÑADI METODOS GETTERS

   
   //AÑADI -  Constructor alternativo sin notas
   public LineaPedido(int idLinea, int cantidad, Plato plato, Pedido pedido) {
       this(idLinea, cantidad, plato, "", pedido);
   }
   
   // Getters faltantes
   public int getIdLinea() {
       return idLinea;
   }
   
   public String getNotas() {
       return notas;
   }
   
   public Pedido getPedido() {
       return pedido;
   }
   
   
//YA ESTABA IMPLEMENTADO POR EL COMPIS
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
