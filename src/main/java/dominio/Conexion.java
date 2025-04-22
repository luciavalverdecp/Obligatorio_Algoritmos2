package dominio;

public class Conexion {
    private String codigoCiudadOrigen;
    private String codigoCiudadDestino;

    public Conexion() {
    }

    public Conexion(String codigoCiudadOrigen, String codigoCiudadDestino) {
        this.codigoCiudadOrigen = codigoCiudadOrigen;
        this.codigoCiudadDestino = codigoCiudadDestino;
    }

    public String getCodigoCiudadOrigen() {
        return codigoCiudadOrigen;
    }

    public void setCodigoCiudadOrigen(String codigoCiudadOrigen) {
        this.codigoCiudadOrigen = codigoCiudadOrigen;
    }

    public String getCodigoCiudadDestino() {
        return codigoCiudadDestino;
    }

    public void setCodigoCiudadDestino(String codigoCiudadDestino) {
        this.codigoCiudadDestino = codigoCiudadDestino;
    }
}
