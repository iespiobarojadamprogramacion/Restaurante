package restaurante.modelo;
public class Plato {
    private int idPlato;
    private String nombre;
    private TipoPlato tipo;
    private double precioUnitario;
    private boolean disponibilidad;
    // Constructor
    public Plato(int idPlato, String nombre, TipoPlato tipo, double precioUnitario, boolean disponibilidad) {
        this.idPlato = idPlato;
        this.nombre = nombre;
        this.tipo = tipo;
        this.precioUnitario = precioUnitario;
        this.disponibilidad = disponibilidad;
    }
    public void cambiarDisponibilidad(boolean disponible) {
        this.disponibilidad = disponible;
    }
    public void actualizarPrecio(double nuevoPrecio) {
        this.precioUnitario = nuevoPrecio;
    }
    public double getPrecioUnitario() {
        return precioUnitario;
    }
    public String getNombre() {
        return nombre;
    }
}
