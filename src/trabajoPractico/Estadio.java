package trabajoPractico;

public class Estadio extends Sede {
	public Estadio(String nombre, String direccion, int capacidadMaxima) {
        super(nombre, direccion, capacidadMaxima);
    }

    @Override
    public double calcularPrecioEntrada(double precioBase, String sector) {
        return precioBase; // Precio único para el campo
    }
}
