package sistema;

import abb.ABB;
import dominio.Viajero;
import dominio.ViajeroPorCorreoWrapper;
import interfaz.*;

public class ImplementacionSistema implements Sistema  {

    private ABB<Viajero> abbViajeros;
    private ABB<ViajeroPorCorreoWrapper> abbViajerosPorCorreo;
    private ABB<Viajero> abbViajerosPlatino;
    private ABB<Viajero> abbViajerosEstandar;
    private ABB<Viajero> abbViajerosFrecuente;

    private ABB abbVuelos;
    private ABB abbCiudades;
    private ABB abbConexiones;
    private int maximoCiudades;

    public ImplementacionSistema() {
        this.abbViajeros = new ABB<>();
        this.abbViajerosPorCorreo = new ABB<>();
        this.abbViajerosPlatino = new ABB<>();
        this.abbViajerosEstandar = new ABB<>();
        this.abbViajerosFrecuente = new ABB<>();
        this.abbVuelos = new ABB<>();
        this.abbCiudades = new ABB<>();
        this.abbConexiones = new ABB<>();
    }

    @Override
    public Retorno inicializarSistema(int maxCiudades) {
        if(maxCiudades <= 4){
            return Retorno.error1("La cantidad de ciudades a ingresar es 5 o superior.");
        }
        this.abbViajeros = new ABB<>();
        this.abbViajerosPorCorreo = new ABB<>();
        this.abbViajerosPlatino = new ABB<>();
        this.abbViajerosEstandar = new ABB<>();
        this.abbViajerosFrecuente = new ABB<>();
        this.abbVuelos = new ABB<>();
        this.abbCiudades = new ABB<>();
        this.abbConexiones = new ABB<>();
        this.maximoCiudades = maxCiudades;
        return Retorno.ok();
    }

    @Override
    public Retorno registrarViajero(String cedula, String nombre, String correo, int edad, Categoria categoria) { //PREGUNTAR NULL DE EDAD O VACIO
        Viajero viajero = new Viajero(cedula, nombre, correo, edad, categoria);

        if(cedula == null || cedula == "" || nombre == null || nombre == "" || correo == null || correo == "" || categoria == null || categoria.getTexto() == ""){
            return Retorno.error1("Alguno de los parametros ingresados es vacio o nulo.");
        }else if(viajero.validarCedula(cedula)){
            return Retorno.error2("La cedula no presenta un formato valido (N.NNN.NNN-N ó NNN.NNN-N)");
        }else if(viajero.validarCorreo(correo)){
            return Retorno.error3("El correo no presenta un formato valido");
        }else if(edad < 0 || edad > 139){
            return Retorno.error4("Edad no validad.");
        }else if(buscarViajeroPorCedula(cedula) == Retorno.ok()){ //PREGUNTAR SI ESTA BIEN LLAMAR A ESTE METODO Y SI ES NECESARIO DEFINI UN EQUALS
            return Retorno.error5("Error, intentelo de nuevo"); //PREGUNTAR SI ES NECESARIO ESPECIFICAR EL MENSAJE EN ESTOS CASOS
        }else if(buscarViajeroPorCorreo(correo) == Retorno.ok()){
            return Retorno.error6("Error");
        }

        abbViajeros.agregar(viajero);

        ViajeroPorCorreoWrapper viajeroCorreo = new ViajeroPorCorreoWrapper(viajero);
        abbViajerosPorCorreo.agregar(viajeroCorreo);

        if(categoria.getTexto() == "Platino"){
            abbViajerosPlatino.agregar(viajero);
        }else if(categoria.getTexto() == "Estándar"){
            abbViajerosEstandar.agregar(viajero);
        }else {
            abbViajerosFrecuente.agregar(viajero);
        }
        return Retorno.ok();
    }

    @Override
    public Retorno buscarViajeroPorCedula(String cedula) {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno buscarViajeroPorCorreo(String correo) {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno listarViajerosPorCedulaAscendente() {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno listarViajerosPorCedulaDescendente() {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno listarViajerosPorCorreoAscendente() {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno listarViajerosPorCategoria(Categoria unaCategoria) {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno listarViajerosDeUnRangoAscendente(int rango) {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno registrarCiudad(String codigo, String nombre) {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno registrarConexion(String codigoCiudadOrigen, String codigoCiudadDestino) {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno registrarVuelo(String codigoCiudadOrigen, String codigoCiudadDestino, String codigoDeVuelo, double combustible, double minutos, double costoEnDolares, TipoVuelo tipoDeVuelo) {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno actualizarVuelo(String codigoCiudadOrigen, String codigoCiudadDestino, String codigoDeVuelo, double combustible, double minutos, double costoEnDolares, TipoVuelo tipoDeVuelo) {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno listadoCiudadesCantDeEscalas(String codigoCiudadOrigen, int cantidad) {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno viajeCostoMinimoMinutos(String codigoCiudadOrigen, String codigoCiudadDestino, TipoVueloPermitido tipoVueloPermitido) {
        return Retorno.noImplementada();
    }

    @Override
    public Retorno viajeCostoMinimoDolares(String codigoCiudadOrigen, String codigoCiudadDestino, TipoVueloPermitido tipoVueloPermitido) {
        return Retorno.noImplementada();
    }

}
