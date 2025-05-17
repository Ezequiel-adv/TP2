package ar.edu.ungs.prog2.ticketek;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private String email;
    private String nombre;
    private String apellido;
    private String contraseña;

    private List<Entrada> entradas;

    public Usuario(String email, String nombre, String apellido, String contraseña) {
        this.email = email;
        this.nombre = nombre;
        this.apellido = apellido;
        this.contraseña = contraseña;
        this.entradas = new ArrayList<>();
    }

    public String getEmail() {
        return email;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public boolean autenticar(String contraseña) {
        return this.contraseña.equals(contraseña);
    }

    public void agregarEntrada(Entrada entrada) {
        entradas.add(entrada);
    }

    public List<Entrada> getEntradas() {
        return new ArrayList<>(entradas); // Para evitar modificaciones externas
    }

    public List<Entrada> getEntradasFuturas() {
        List<Entrada> futuras = new ArrayList<>();
        for (Entrada e : entradas) {
            if (e.getFecha().isAfter(java.time.LocalDate.now())) {
                futuras.add(e);
            }
        }
        return futuras;
    }

    public boolean eliminarEntrada(String codigoEntrada) {
        return entradas.removeIf(e -> e.getCodigo().equals(codigoEntrada));
    }
}
