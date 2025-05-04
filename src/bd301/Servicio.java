package bd301;

public class Servicio {
    private int id;
    private String nombre;
    private String descripcion;
    private int duracionMin;
    private double precio;

    public Servicio() {}

    public Servicio(int id, String nombre, String descripcion, int duracionMin, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracionMin = duracionMin;
        this.precio = precio;
    }

    public int getId() { 
        return id; 
    }
    public void setId(int id) { 
        this.id = id; 
    }

    public String getNombre() { 
        return nombre; 
    }
    public void setNombre(String nombre) {
        this.nombre = nombre; 
    }

    public String getDescripcion() { 
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion; 
    }

    public int getDuracionMin() {
        return duracionMin; 
    }
    public void setDuracionMin(int duracionMin) {
        this.duracionMin = duracionMin; 
    }

    public double getPrecio() {
        return precio; 
    }
    public void setPrecio(double precio) { 
        this.precio = precio;
    }
}
