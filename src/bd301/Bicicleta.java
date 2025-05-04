package bd301;

public class Bicicleta {
    private int id;
    private int idUsuario;
    private String marca;
    private String modelo;
    private String color;
    private String serial;

    public Bicicleta() {}

    public Bicicleta(int id, int idUsuario, String marca, String modelo, String color, String serial) {
        this.id = id;
        this.idUsuario = idUsuario;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.serial = serial;
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
    public String getMarca() {
        return marca; 
    }
    public void setMarca(String marca) {
        this.marca = marca; 
    }
    public String getModelo() {
        return modelo; 
    }
    public void setModelo(String modelo) {
        this.modelo = modelo; 
    }
    public String getColor() {
        return color; 
    }
    public void setColor(String color) {
        this.color = color; 
    }
    public String getSerial() {
        return serial; 
    }
    public void setSerial(String serial) {
        this.serial = serial; 
    }
}