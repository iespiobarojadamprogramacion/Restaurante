package modelo;

public class clientes {
    private static int contador = 1; 
    private int idCliente;
    private String nombre;
    private String telefono;
    private String correo;

    public clientes(String nombre, String telefono, String correo) {
        this.idCliente = contador++; 
        this.nombre= nombre;
        this.telefono = telefono;
        this.correo = correo;
    }

    public void actualizarContacto(String nombre, String telefono, String correo) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
    }

    public String obtenerNombre() {
        return nombre;
    }

    public int getICliente() {
        return idCliente;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }
}