package ar.edu.ungs.prog2.ticketek;

public class Sector {
    private int numero;           
    private TipoSector tipo;      
    private int asientosPorFila;  

    public Sector(int numero, TipoSector tipo, int asientosPorFila) {
        this.numero = numero;
        this.tipo = tipo;
        this.asientosPorFila = asientosPorFila;
    }

    public int getNumero() {
        return numero;
    }

    public TipoSector getTipo() {
        return tipo;
    }

    public int getAsientosPorFila() {
        return asientosPorFila;
    }
}
