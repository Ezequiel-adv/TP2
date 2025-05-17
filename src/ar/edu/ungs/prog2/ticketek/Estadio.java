package ar.edu.ungs.prog2.ticketek;

import java.util.List;

public class Estadio extends Sede {
    public Estadio(String nombre, String direccion, int capacidadMaxima) {
        super(nombre, direccion, capacidadMaxima);
    }

    @Override
    public double calcularPrecio(double precioBase, Sector sector) {
        return precioBase;
    }
}