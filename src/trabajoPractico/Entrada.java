package trabajoPractico;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Entrada implements IEntrada {
    private String codigo;
    private Funcion funcion;
    private String sector;
    private String ubicacion;
    private Espectaculo espectaculo;

    public Entrada(Espectaculo espectaculo, Funcion funcion, String sector, String ubicacion) {
        this.codigo = generarCodigo();
        this.funcion = funcion;
        this.sector = sector;
        this.ubicacion = ubicacion;
        this.espectaculo = espectaculo;
    }

    @Override
    public double precio() {
        return funcion.calcularPrecio(sector);
    }

    @Override
    public String ubicacion() {
        return ubicacion;
    }

    public boolean esFutura() {
    	 return funcion.getFecha().getFecha().isAfter(java.time.LocalDate.now());
    }

    private String generarCodigo() {
        return UUID.randomUUID().toString();
    }

    @Override
    public String toString() {
    	String fecha = funcion.getFecha().toString();
        if (!esFutura()) {
            fecha += " P";
        }
        return String.format("%s - %s - %s - %s - %s", codigo, espectaculo.getNombre(), fecha, funcion.getSede().getNombre(), ubicacion());
    }

    public double getPrecio() {
        return precio();
    }

    public String getCodigo() {
        return codigo;
    }

    public String getSector() {
        return sector;
    }

    public Espectaculo getEspectaculo() {
        return espectaculo;
    }
}
