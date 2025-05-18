package trabajoPractico;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ticketek implements ITicketek {
	
	 	private Map<String, Usuario> usuarios;
	    private Map<String, Sede> sedes;
	    private Map<String, Espectaculo> espectaculos;

	    public Ticketek() {
	        this.usuarios = new HashMap<>();
	        this.sedes = new HashMap<>();
	        this.espectaculos = new HashMap<>();
	    }

	@Override
	public void registrarSede(String nombre, String direccion, int capacidadMaxima) {
		 if (sedes.containsKey(nombre)) {
	            throw new RuntimeException("La sede ya está registrada.");
	        }
	        sedes.put(nombre, new Estadio(nombre, direccion, capacidadMaxima));
	    }
	

	@Override
	public void registrarSede(String nombre, String direccion, int capacidadMaxima, int asientosPorFila,
			String[] sectores, int[] capacidad, int[] porcentajeAdicional) {
		if (sedes.containsKey(nombre)) {
            throw new RuntimeException("La sede ya está registrada.");
        }
        Map<String, Sector> sectoresMap = new HashMap<>();
        for (int i = 0; i < sectores.length; i++) {
            sectoresMap.put(sectores[i], new Sector(sectores[i], porcentajeAdicional[i], capacidad[i]));
        }
        sedes.put(nombre, new Teatro(nombre, direccion, capacidadMaxima, asientosPorFila, sectoresMap));
    }

	@Override
	public void registrarSede(String nombre, String direccion, int capacidadMaxima, int asientosPorFila,
			int cantidadPuestos, double precioConsumicion, String[] sectores, int[] capacidad,
			int[] porcentajeAdicional) {
		
		if (sedes.containsKey(nombre)) {
            throw new RuntimeException("La sede ya está registrada.");
        }
        Map<String, Sector> sectoresMap = new HashMap<>();
        for (int i = 0; i < sectores.length; i++) {
            sectoresMap.put(sectores[i], new Sector(sectores[i], porcentajeAdicional[i], capacidad[i]));
        }
        sedes.put(nombre, new MiniEstadio(nombre, direccion, capacidadMaxima, asientosPorFila, cantidadPuestos, precioConsumicion, sectoresMap));
    }

	@Override
	public void registrarUsuario(String email, String nombre, String apellido, String contrasenia) {
		if (usuarios.containsKey(email)) {
	        throw new RuntimeException("El usuario ya está registrado.");
	    }
	    usuarios.put(email, new Usuario(email, nombre, apellido, contrasenia));
	}

	@Override
	public void registrarEspectaculo(String nombre) {
		 if (espectaculos.containsKey(nombre)) {
		        throw new IllegalArgumentException("El espectáculo ya está registrado.");
		    }
		    espectaculos.put(nombre, new Espectaculo(nombre));
		}
	

	@Override
	public void agregarFuncion(String nombreEspectaculo, String fecha, String sede, double precioBase) {
		Espectaculo espectaculo = espectaculos.get(nombreEspectaculo);
	    if (espectaculo == null) {
	        throw new RuntimeException("El espectáculo no está registrado.");
	    }
	    Sede sedeEncontrada = sedes.get(sede);
	    if (sedeEncontrada == null) {
	        throw new RuntimeException("La sede no está registrada.");
	    }
	    Fecha fechaConvertida = new Fecha(fecha);
	    Funcion funcion = new Funcion(sedeEncontrada, fechaConvertida, precioBase);
	    
	    espectaculo.agregarFuncion(funcion);
	
	}

	@Override
	public List<IEntrada> venderEntrada(String nombreEspectaculo, String fecha, String email, String contrasenia,
			int cantidadEntradas) {
		Usuario usuario = usuarios.get(email);
        if (usuario == null || !usuario.autenticar(contrasenia)) {
            throw new RuntimeException("Usuario o contraseña incorrectos.");
        }

        Espectaculo espectaculo = espectaculos.get(nombreEspectaculo);
        if (espectaculo == null) {
            throw new RuntimeException("El espectáculo no está registrado.");
        }

        Funcion funcion = espectaculo.obtenerFuncion(fecha);
        if (funcion == null) {
            throw new RuntimeException("La función no está registrada.");
        }

        if (!(funcion.getSede() instanceof Estadio)) {
            throw new RuntimeException("La sede no es un estadio.");
        }

        List<IEntrada> entradas = new ArrayList<>();
        for (int i = 0; i < cantidadEntradas; i++) {
            Entrada entrada = new Entrada(espectaculo, funcion, "CAMPO", "CAMPO");
            usuario.comprarEntrada(entrada);
            entradas.add(entrada);
        }

        return entradas;
    }
 
	

	@Override
	public List<IEntrada> venderEntrada(String nombreEspectaculo, String fecha, String email, String contrasenia,
			String sector, int[] asientos) {
				return null;
		
    }
		
    

	    

	@Override
	public String listarFunciones(String nombreEspectaculo) {
		return nombreEspectaculo;
		
	}

	@Override
	public List<IEntrada> listarEntradasEspectaculo(String nombreEspectaculo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IEntrada> listarEntradasFuturas(String email, String contrasenia) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IEntrada> listarTodasLasEntradasDelUsuario(String email, String contrasenia) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean anularEntrada(IEntrada entrada, String contrasenia) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public IEntrada cambiarEntrada(IEntrada entrada, String contrasenia, String fecha, String sector, int asiento) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IEntrada cambiarEntrada(IEntrada entrada, String contrasenia, String fecha) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double costoEntrada(String nombreEspectaculo, String fecha) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double costoEntrada(String nombreEspectaculo, String fecha, String sector) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double totalRecaudado(String nombreEspectaculo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double totalRecaudadoPorSede(String nombreEspectaculo, String nombreSede) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Ticketek:\n");
        sb.append("Usuarios: ").append(usuarios.size()).append("\n");
        sb.append("Sedes: ").append(sedes.size()).append("\n");
        sb.append("Espectáculos: ").append(espectaculos.size()).append("\n");
        return sb.toString();
    }

}
