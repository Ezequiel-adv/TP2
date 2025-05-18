package trabajoPractico;

import java.util.Map;

public class MiniEstadio extends Teatro{
	private int cantidadPuestos;
    private double precioConsumicion;

    public MiniEstadio(String nombre, String direccion, int capacidadMaxima, int asientosPorFila, int cantidadPuestos, double precioConsumicion, Map<String, Sector> sectores) {
        super(nombre, direccion, capacidadMaxima, asientosPorFila, sectores);
        this.cantidadPuestos = cantidadPuestos;
        this.precioConsumicion = precioConsumicion;
    }

    @Override
    public double calcularPrecioEntrada(double precioBase, String sector) {
        double precio = super.calcularPrecioEntrada(precioBase, sector);
        
        return precio + precioConsumicion;
    }

	public int getCantidadPuestos() {
		return cantidadPuestos;
	}

	public double getPrecioConsumicion() {
		return precioConsumicion;
	}
}
