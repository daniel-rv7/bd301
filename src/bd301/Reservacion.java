package bd301;

import java.util.Date;

public class Reservacion {
    private int id;
    private int idBicicleta;
    private int idServicio;
    private int idEmpleado;
    private Date fecha;
    private String horaInicio;
    private String estado;

    public Reservacion() {}

    public Reservacion(int id, int idBicicleta, int idServicio, int idEmpleado, Date fecha, String horaInicio, String estado) {
        this.id = id;
        this.idBicicleta = idBicicleta;
        this.idServicio = idServicio;
        this.idEmpleado = idEmpleado;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.estado = estado;
    }

    public int getId() { 
        return id; 
    }
    public void setId(int id) {
        this.id = id; 
    }

    public int getIdBicicleta() {
        return idBicicleta; 
    }
    public void setIdBicicleta(int idBicicleta) {
        this.idBicicleta = idBicicleta; 
    }

    public int getIdServicio() { 
        return idServicio;
    }
    public void setIdServicio(int idServicio) {
        this.idServicio = idServicio; 
    }

    public int getIdEmpleado() { 
        return idEmpleado; 
    }
    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado; 
    }

    public Date getFecha() {
        return fecha; 
    }
    public void setFecha(Date fecha) { 
        this.fecha = fecha; 
    }

    public String getHoraInicio() { 
        return horaInicio; 
    }
    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio; 
    }

    public String getEstado() {
        return estado; 
    }
    public void setEstado(String estado) { 
        this.estado = estado; 
    }
}
