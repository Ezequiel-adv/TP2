package trabajoPractico;

import java.util.Map;

public class Teatro extends Sede {
	private int asientosPorFila;
    private Map<String, Sector> sectores;

    public Teatro(String nombre, String direccion, int capacidadMaxima, int asientosPorFila, Map<String, Sector> sectores) {
        super(nombre, direccion, capacidadMaxima);
        this.asientosPorFila = asientosPorFila;
        this.sectores = sectores;
    }

    @Override
    public double calcularPrecioEntrada(double precioBase, String sector) {
        Sector s = sectores.get(sector);
        if (s != null) {
            return precioBase * (1 + s.getIncrementoPrecio() / 100.0);
        }
        return precioBase;
    }
    
    public int getAsientosPorFila() {
    	return asientosPorFila;
    }

	public Map<String, Sector> getSectores() {
		
		return sectores;
	}

}
