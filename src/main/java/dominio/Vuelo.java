package dominio;

import interfaz.TipoVuelo;

public class Vuelo {
    private String codigoCiudadOrigen;
    private String codigoCiudadDestino;
    private String codigoVuelo;
    private double combustible;
    private double minutos;
    private double costoDolares;
    private TipoVuelo tipoVuelo;

    public Vuelo() {
    }

    public Vuelo(String codigoVuelo, String codigoCiudadOrigen, String codigoCiudadDestino, double combustible, double minutos, double costoDolares, TipoVuelo tipoVuelo) {
        this.codigoVuelo = codigoVuelo;
        this.codigoCiudadOrigen = codigoCiudadOrigen;
        this.codigoCiudadDestino = codigoCiudadDestino;
        this.combustible = combustible;
        this.minutos = minutos;
        this.costoDolares = costoDolares;
        this.tipoVuelo = tipoVuelo;
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

    public String getCodigoVuelo() {
        return codigoVuelo;
    }

    public void setCodigoVuelo(String codigoVuelo) {
        this.codigoVuelo = codigoVuelo;
    }

    public double getCombustible() {
        return combustible;
    }

    public void setCombustible(double combustible) {
        this.combustible = combustible;
    }

    public double getMinutos() {
        return minutos;
    }

    public void setMinutos(double minutos) {
        this.minutos = minutos;
    }

    public double getCostoDolares() {
        return costoDolares;
    }

    public void setCostoDolares(double costoDolares) {
        this.costoDolares = costoDolares;
    }

    public TipoVuelo getTipoVuelo() {
        return tipoVuelo;
    }

    public void setTipoVuelo(TipoVuelo tipoVuelo) {
        this.tipoVuelo = tipoVuelo;
    }
}
