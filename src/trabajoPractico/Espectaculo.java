package trabajoPractico;

import java.util.ArrayList;
import java.util.List;

public class Espectaculo {
    private String nombre;
    private List<Funcion> funciones;

    public Espectaculo(String nombre) {
        this.nombre = nombre;
        this.funciones = new ArrayList<>();
    }

    public void agregarFuncion(Funcion funcion) {
        if (validarFuncion(funcion)) {
            funciones.add(funcion);
        } else {
            throw new RuntimeException("La función se solapa con otra función existente.");
        }
    }

    public boolean validarFuncion(Funcion nuevaFuncion) {
        for (Funcion funcion : funciones) {
            if (funcion.getFecha().equals(nuevaFuncion.getFecha())) {
                return false; // La función se solapa con otra existente
            }
        }
        return true; // La función no se solapa
    }

    public Funcion obtenerFuncion(String fecha) {
        for (Funcion funcion : funciones) {
            if (funcion.getFecha().equals(fecha)) {
                return funcion;
            }
        }
        return null; // No se encontró la función
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public List<Funcion> getFunciones() {
        return new ArrayList<>(funciones);
    }
}
