public class PuntoAcceso {
    private String codigo;
    private String nombre;
    private String ubicacion;
    private int capacidadMaximaPorHora;
    private String estado;

    public PuntoAcceso(String codigo, String nombre, String ubicacion,
                       int capacidad, String estado) {
        setCodigo(codigo);
        setNombre(nombre);
        setUbicacion(ubicacion);
        setCapacidadMaximaPorHora(capacidad);
        setEstado(estado);
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public int getCapacidadMaximaPorHora() {
        return capacidadMaximaPorHora;
    }

    public String getEstado() {
        return estado;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setCapacidadMaximaPorHora(int capacidad) {
        if (capacidad <= 0) {
            throw new IllegalArgumentException("La capacidad debe ser mayor que 0.");
        }
        this.capacidadMaximaPorHora = capacidad;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Codigo: " + codigo +
                "\nNombre: " + nombre +
                "\nUbicacion: " + ubicacion +
                "\nCapacidad maxima por hora: " + capacidadMaximaPorHora +
                "\nEstado: " + estado;
    }
}
