package bd301;

import java.util.Date;

public class Notificacion {
    private int id;
    private int idUsuario;
    private String mensaje;
    private Date fecha;
    private String estado;

    public Notificacion() {}

    public Notificacion(int id, int idUsuario, String mensaje, Date fecha, String estado) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.mensaje = mensaje;
        this.fecha = fecha;
        this.estado = estado;
    }

    public int getId() { 
        return id; 
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getIdUsuario() { 
        return idUsuario; 
    }
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getMensaje() { 
        return mensaje; 
    }
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje; 
    }

    public Date getFecha() {
        return fecha; 
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha; 
    }

    public String getEstado() { 
        return estado; 
    }
    public void setEstado(String estado) {
        this.estado = estado; 
    }
}
