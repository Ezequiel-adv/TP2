package ar.edu.ungs.prog2.ticketek;

import java.time.LocalDate;

public class Entrada implements IEntrada {
    private String codigo; // Código único de la entrada
    private String nombreEspectaculo;
    private LocalDate fecha;
    private Sede sede;
    private String sector; // Puede ser null si es estadio
    private int asiento;

    public Entrada(String codigo, String nombreEspectaculo, LocalDate fecha, Sede sede, String sector, int asiento) {
        this.codigo = codigo;
        this.nombreEspectaculo = nombreEspectaculo;
        this.fecha = fecha;
        this.sede = sede;
        this.sector = sector;
        this.asiento = asiento;
    }

    public String getSector() {
        return sector;
    }

    public int getAsiento() {
        return asiento;
    }

    @Override
    public String toString() {
        return "Entrada{" +
                "codigo='" + codigo + '\'' +
                ", espectaculo='" + nombreEspectaculo + '\'' +
                ", fecha=" + fecha +
                ", sede=" + sede.getNombre() +
                ", sector='" + sector + '\'' +
                ", asiento=" + asiento +
                '}';
    }

	@Override
	public double precio() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String ubicacion() {
		// TODO Auto-generated method stub
		return null;
	}

	public LocalDate getFecha() {
		// TODO Auto-generated method stub
		return null;
	}

	public Object getCodigo() {
		// TODO Auto-generated method stub
		return null;
	}
}
