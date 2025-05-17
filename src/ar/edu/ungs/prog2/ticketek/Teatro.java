package ar.edu.ungs.prog2.ticketek;

import java.util.List;

public class Teatro extends Sede {
    private List<Sector> sectores;

    public Teatro(String nombre, String direccion, int capacidadMaxima, List<Sector> sectores) {
        super(nombre, direccion, capacidadMaxima);
        this.sectores = sectores;
    }

    @Override
    public double calcularPrecio(double precioBase, Sector sector) {
        switch (sector.getTipo()) {
            case VIP: return precioBase * 1.70;
            case COMUN: return precioBase * 1.40;
            case BAJA: return precioBase * 1.50;
            case ALTA: return precioBase;
        }
        return precioBase;
    }
}