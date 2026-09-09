import java.util.ArrayList;

public class Parque {
    private String nombre;
    private String codigoIdentificacion;
    private String nombreEncargado;
    private PuntoAcceso[] puntosAcceso;
    private ArrayList<Visitante> visitantes;

    public Parque(String nombre, String codigo, String encargado) {
        this.nombre = nombre;
        this.codigoIdentificacion = codigo;
        this.nombreEncargado = encargado;
        this.puntosAcceso = new PuntoAcceso[5];
        this.visitantes = new ArrayList<>();
    }

    public boolean habilitarPunto(int posicion, PuntoAcceso punto) {
        if (posicion < 0 || posicion >= puntosAcceso.length) {
            return false;
        }

        if (puntosAcceso[posicion] != null) {
            return false;
        }

        puntosAcceso[posicion] = punto;
        return true;
    }

    public void consultarPuntos() {
        for (int i = 0; i < puntosAcceso.length; i++) {
            System.out.println("\nPosicion " + i + ":");

            if (puntosAcceso[i] == null) {
                System.out.println("No hay punto de acceso registrado.");
            } else {
                System.out.println(puntosAcceso[i]);
            }
        }
    }

    public PuntoAcceso obtenerPunto(int posicion) {
        if (posicion < 0 || posicion >= puntosAcceso.length) {
            return null;
        }

        return puntosAcceso[posicion];
    }

    public boolean modificarPunto(int posicion, int capacidad, String estado) {
        PuntoAcceso punto = obtenerPunto(posicion);

        if (punto == null) {
            return false;
        }

        punto.setCapacidadMaximaPorHora(capacidad);
        punto.setEstado(estado);
        return true;
    }

    public boolean cerrarPunto(int posicion) {
        PuntoAcceso punto = obtenerPunto(posicion);

        if (punto == null) {
            return false;
        }

        punto.setEstado("Cerrado");
        return true;
    }

    public int contarPuntosHabilitados() {
        int contador = 0;

        for (PuntoAcceso punto : puntosAcceso) {
            if (punto != null && punto.getEstado().equalsIgnoreCase("Habilitado")) {
                contador++;
            }
        }

        return contador;
    }

    public int contarEspaciosDisponibles() {
        int contador = 0;

        for (PuntoAcceso punto : puntosAcceso) {
            if (punto == null) {
                contador++;
            }
        }

        return contador;
    }

    public PuntoAcceso puntoMayorCapacidad() {
        PuntoAcceso mayor = null;

        for (PuntoAcceso punto : puntosAcceso) {
            if (punto != null &&
                    (mayor == null ||
                    punto.getCapacidadMaximaPorHora() > mayor.getCapacidadMaximaPorHora())) {
                mayor = punto;
            }
        }

        return mayor;
    }

    public boolean registrarVisitante(Visitante visitante) {
        if (buscarVisitante(visitante.getCodigoEntrada()) != null) {
            return false;
        }

        visitantes.add(visitante);
        return true;
    }

    public void consultarVisitantes() {
        if (visitantes.isEmpty()) {
            System.out.println("No hay visitantes registrados.");
            return;
        }

        for (Visitante visitante : visitantes) {
            System.out.println(visitante);
            System.out.println("----------------------");
        }
    }

    public Visitante buscarVisitante(String codigo) {
        for (Visitante visitante : visitantes) {
            if (visitante.getCodigoEntrada().equalsIgnoreCase(codigo)) {
                return visitante;
            }
        }

        return null;
    }

    public boolean modificarVisitante(String codigo, String nombre, int edad,
                                     int atracciones, int puntos) {
        Visitante visitante = buscarVisitante(codigo);

        if (visitante == null) {
            return false;
        }

        visitante.setNombre(nombre);
        visitante.setEdad(edad);
        visitante.setAtraccionesVisitadas(atracciones);
        visitante.setPuntosAcumulados(puntos);
        return true;
    }

    public boolean eliminarVisitante(String codigo) {
        Visitante visitante = buscarVisitante(codigo);

        if (visitante == null) {
            return false;
        }

        visitantes.remove(visitante);
        return true;
    }

    public int contarVisitantes() {
        return visitantes.size();
    }

    public Visitante visitanteMasPuntos() {
        if (visitantes.isEmpty()) {
            return null;
        }

        Visitante mayor = visitantes.get(0);

        for (Visitante visitante : visitantes) {
            if (visitante.getPuntosAcumulados() > mayor.getPuntosAcumulados()) {
                mayor = visitante;
            }
        }

        return mayor;
    }

    public Visitante visitanteMasAtracciones() {
        if (visitantes.isEmpty()) {
            return null;
        }

        Visitante mayor = visitantes.get(0);

        for (Visitante visitante : visitantes) {
            if (visitante.getAtraccionesVisitadas() > mayor.getAtraccionesVisitadas()) {
                mayor = visitante;
            }
        }

        return mayor;
    }

    public double promedioEdad() {
        if (visitantes.isEmpty()) {
            return 0;
        }

        int sumaEdades = 0;

        for (Visitante visitante : visitantes) {
            sumaEdades += visitante.getEdad();
        }

        return (double) sumaEdades / visitantes.size();
    }
}
