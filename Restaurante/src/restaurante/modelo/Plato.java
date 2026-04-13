package restaurante.modelo;
public class Plato {
	//ATRIBUTOS
	private static int indice = 0;
    private int idPlato;
    private String nombre;
    private TipoPlato tipo;
    private double precioUnitario;
    private boolean disponibilidad;
    
    // Constructor
    public Plato(String nombre, TipoPlato tipo, double precioUnitario) {
        idPlato = indice++;
        this.nombre = nombre;
        this.tipo = tipo;
        this.precioUnitario = precioUnitario;
        disponibilidad = true;
    }

    public void cambiarDisponibilidad(boolean disponible) {
        disponibilidad = disponible;
    }
    
    public void actualizarPrecio(double nuevoPrecio) {
        precioUnitario = nuevoPrecio;
    }
    
    public int getIdPlato() {
		return idPlato;
	}

	public double getPrecioUnitario() {
        return precioUnitario;
    }
    
    public String getNombre() {
        return nombre;
    }

	public boolean isDisponibilidad() {
		return disponibilidad;
	}

}
