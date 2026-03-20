package restaurante.modelo;

import java.util.ArrayList;

public class Clientes {
    private static int contador = 1; 
    private int idCliente;
    private String nombre;
    private String telefono;
    private String correo;
    private ArrayList <Reservas> reservas;

    public Clientes(String nombre, String telefono, String correo) {
        idCliente = contador++; 
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

    public int getIDCliente() {
        return idCliente;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() {
        return correo;
    }
}