public class Visitante {
    private final String codigoEntrada;
    private String nombre;
    private int edad;
    private int atraccionesVisitadas;
    private int puntosAcumulados;

    public Visitante(String codigo, String nombre, int edad,
                     int atracciones, int puntos) {
        validarTexto(codigo, "El codigo de entrada");

        this.codigoEntrada = codigo.trim();

        setNombre(nombre);
        setEdad(edad);
        setAtraccionesVisitadas(atracciones);
        setPuntosAcumulados(puntos);
    }

    public String getCodigoEntrada() {
        return codigoEntrada;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public int getAtraccionesVisitadas() {
        return atraccionesVisitadas;
    }

    public int getPuntosAcumulados() {
        return puntosAcumulados;
    }

    public void setNombre(String nombre) {
        validarTexto(nombre, "El nombre");
        this.nombre = nombre.trim();
    }

    public void setEdad(int edad) {
        if (edad <= 0) {
            throw new IllegalArgumentException(
                    "La edad debe ser mayor que cero."
            );
        }

        this.edad = edad;
    }

    public void setAtraccionesVisitadas(int atracciones) {
        if (atracciones < 0) {
            throw new IllegalArgumentException(
                    "Las atracciones no pueden ser negativas."
            );
        }

        this.atraccionesVisitadas = atracciones;
    }

    public void setPuntosAcumulados(int puntos) {
        if (puntos < 0) {
            throw new IllegalArgumentException(
                    "Los puntos no pueden ser negativos."
            );
        }

        this.puntosAcumulados = puntos;
    }

    private static void validarTexto(String valor, String campo) {
        if (valor == null || valor.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    campo + " no puede estar vacio."
            );
        }
    }

    @Override
    public String toString() {
        return "Visitante{" +
                "codigoEntrada='" + codigoEntrada + '\'' +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", atraccionesVisitadas=" + atraccionesVisitadas +
                ", puntosAcumulados=" + puntosAcumulados +
                '}';
    }
 {
    
}
