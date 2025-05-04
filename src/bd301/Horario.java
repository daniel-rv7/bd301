package bd301;

public class Horario {
    private int id;
    private int idEmpleado;
    private String diaSemana;
    private String horarioInicio;
    private String horaFin;

    public Horario() {}

    public Horario(int id, int idEmpleado, String diaSemana, String horarioInicio, String horaFin) {
        this.id = id;
        this.idEmpleado = idEmpleado;
        this.diaSemana = diaSemana;
        this.horarioInicio = horarioInicio;
        this.horaFin = horaFin;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) { 
        this.id = id;
    }
    public int getIdEmpleado() {
        return idEmpleado; 
    }
    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado; 
    }
    public String getDiaSemana() {
        return diaSemana;
    }
    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }
    public String getHorarioInicio() { 
        return horarioInicio;
    }
    public void setHorarioInicio(String horarioInicio) {
        this.horarioInicio = horarioInicio; 
    }
    public String getHoraFin() { 
        return horaFin; 
    }
    public void setHoraFin(String horaFin) {
        this.horaFin = horaFin; 
    }
}