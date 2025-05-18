package trabajoPractico;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String email;
    private String nombre;
    private String apellido;
    private String contrasenia;
    private List<Entrada> entradas;

    public Usuario(String email, String nombre, String apellido, String contrasenia) {
        this.email = email;
        this.nombre = nombre;
        this.apellido = apellido;
        this.contrasenia = contrasenia;
        this.entradas = new ArrayList<>();
    }

    public boolean autenticar(String contrasenia) {
        return this.contrasenia.equals(contrasenia);
    }
	
	
	public void comprarEntrada(Entrada entrada) {
		if (entrada != null) {
            entradas.add(entrada);
        }
	}
	
	/*	
	 public List<Entrada> getTodasLasEntradas() {
	        return new ArrayList<>(entradas);
	    }

	    public boolean anularEntrada(Entrada entrada) {
	        return entradas.remove(entrada);
	    }
*/
	    
	    public String getEmail() {
	        return email;
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public String getApellido() {
	        return apellido;
	    }
	}