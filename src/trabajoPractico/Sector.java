package trabajoPractico;

public class Sector {
	 private String nombre;
	    private int incrementoPrecio;
	    private int capacidad;

	    public Sector(String nombre, int incrementoPrecio, int capacidad) {
	        this.nombre = nombre;
	        this.incrementoPrecio = incrementoPrecio;
	        this.capacidad = capacidad;
	    }

	    public int getIncrementoPrecio() {
	        return incrementoPrecio;
	    }

		public int getCapacidad() {
			return capacidad;
		}

		public String getNombre() {
			return nombre;
		}
}
