package ar.edu.ungs.prog2.ticketek;

import java.util.List;

public class MiniEstadio extends Sede {
    private List<Sector> sectores;
    private double costoConsumicion;

    public MiniEstadio(String nombre, String direccion, int capacidadMaxima, List<Sector> sectores, double costoConsumicion) {
        super(nombre, direccion, capacidadMaxima);
        this.sectores = sectores;
        this.costoConsumicion = costoConsumicion;
    }

    @Override
    public double calcularPrecio(double precioBase, Sector sector) {
        double precioTeatro = switch (sector.getTipo()) {
            case VIP -> precioBase * 1.70;
            case COMUN -> precioBase * 1.40;
            case BAJA -> precioBase * 1.50;
            case ALTA -> precioBase;
        };
        return precioTeatro + costoConsumicion;
    }
}