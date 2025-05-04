package bd301;

public class Empleado {
    private int id;
    private int idUsuario;
    private String horarioInicio;
    private String horarioFin;

    public Empleado() {}

    public Empleado(int id, int idUsuario, String horarioInicio, String horarioFin) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.horarioInicio = horarioInicio;
        this.horarioFin = horarioFin;
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
    public String getHorarioInicio() {
        return horarioInicio; 
    }
    public void setHorarioInicio(String horarioInicio) { 
        this.horarioInicio = horarioInicio; 
    }
    public String getHorarioFin() { 
        return horarioFin; 
    }
    public void setHorarioFin(String horarioFin) {
        this.horarioFin = horarioFin; 
    }
}
