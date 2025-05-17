package ar.edu.ungs.prog2.ticketek;

public abstract class Sede {
	protected String nombre;
	protected String direccion;
	protected int capacidadMaxima;
	
	public Sede(String nombre, String direccion, int capacidadMaxima) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.capacidadMaxima = capacidadMaxima;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getDireccion() {
	return direccion;
	}
	
	public int getCapacidadMaxima() {
		return capacidadMaxima;
	}
	
	public abstract double calcularPrecio(double precioBase, Sector sector);
}
