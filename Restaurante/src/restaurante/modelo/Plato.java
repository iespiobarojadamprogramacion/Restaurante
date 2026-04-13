package restaurante.modelo;
public class Plato {
	
//ATRIBUTOS
    private int idPlato;
    private String nombre;
    private TipoPlato tipo;
    private double precioUnitario;
    private boolean disponibilidad;
 
 // CONSTRUCTOR
    public Plato(int idPlato, String nombre, TipoPlato tipo, double precioUnitario, boolean disponibilidad) {
        this.idPlato = idPlato;
        this.nombre = nombre;
        this.tipo = tipo;
        this.precioUnitario = precioUnitario;
        this.disponibilidad = disponibilidad;
    }
    
 //METODOS AÑADIDOS QUE FALTABAN - k
 // Añade estos métodos a tu clase Plato - GETTERS
    public int getIdPlato() {
        return idPlato;
    }

    public boolean isDisponibilidad() {
        return disponibilidad;
    }

    public TipoPlato getTipo() {
        return tipo;
    }
    
    public String getNombre() {
        return nombre;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }
    
 //Metodos de la propia clase  
    public void cambiarDisponibilidad(boolean disponible) {
        this.disponibilidad = disponible;
    }
    public void actualizarPrecio(double nuevoPrecio) {
        this.precioUnitario = nuevoPrecio;
    }
    
}
