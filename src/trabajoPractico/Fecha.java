package trabajoPractico;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Fecha {
    private LocalDate fecha;
    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Fecha(String fechaComoTexto) {
        try {
            this.fecha = LocalDate.parse(fechaComoTexto, FORMATO);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Formato de fecha inválido. Usá dd/MM/yyyy");
        }
    }
    
    public LocalDate getFecha() {
        return this.fecha;
    }

    public Fecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public boolean esAnteriorA(Fecha otra) {
        return this.fecha.isBefore(otra.fecha);
    }

    public boolean esPosteriorA(Fecha otra) {
        return this.fecha.isAfter(otra.fecha);
    }

    public boolean esIgualA(Fecha otra) {
        return this.fecha.equals(otra.fecha);
    }

    public String comoTexto() {
        return fecha.format(FORMATO);
    }

    public LocalDate comoLocalDate() {
        return fecha;
    }

    @Override
    public String toString() {
        return this.fecha.format(FORMATO);
    }
}
