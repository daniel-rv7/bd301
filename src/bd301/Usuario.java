package bd301;

public class Usuario {
    private int id;
    private String nombre;
    private String apellido;
    private String numero;
    private String correo;
    private String identificacion;
    private int idRol;
    private String estado;

    public Usuario() {}

    public Usuario(int id, String nombre, String apellido, String numero, String correo, String identificacion, int idRol, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.numero = numero;
        this.correo = correo;
        this.identificacion = identificacion;
        this.idRol = idRol;
        this.estado = estado;
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

    public String getApellido() { 
        return apellido; 
    }
    public void setApellido(String apellido) {
        this.apellido = apellido; 
    }

    public String getNumero() {
        return numero; 
    }
    public void setNumero(String numero) {
        this.numero = numero; 
    }

    public String getCorreo() {
        return correo; 
    }
    public void setCorreo(String correo) {
        this.correo = correo; 
    }

    public String getIdentificacion() { 
        return identificacion; 
    }
    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion; 
    }

    public int getIdRol() {
        return idRol; 
    }
    public void setIdRol(int idRol) {
        this.idRol = idRol; 
    }

    public String getEstado() {
        return estado; 
    }
    public void setEstado(String estado) {
        this.estado = estado; 
    }
}
