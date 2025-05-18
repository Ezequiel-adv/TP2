package trabajoPractico;



public class Funcion {

	private Sede sede;
    private Fecha fecha;
    private double precioBase;
    

    public Funcion(Sede sede, Fecha fecha, double precioBase) {
        this.sede = sede;
        this.fecha = fecha;
        this.precioBase = precioBase;
    }

    public double calcularPrecio(String sector) {
        return sede.calcularPrecioEntrada(precioBase, sector);
    }
    

    public Fecha getFecha() {
        return fecha;
    }

    public Sede getSede() {
        return sede;
    }

	public double getPrecioBase() {
		return precioBase;
	}
	
    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

    public void setSede(Sede sede) {
        this.sede = sede;
    }

    @Override
    public String toString() {
        return "Función en " + sede.getNombre() + " el " + fecha + ", base $" + precioBase;
    }


}
