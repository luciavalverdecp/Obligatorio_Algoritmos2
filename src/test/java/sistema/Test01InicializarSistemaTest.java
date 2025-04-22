package sistema;

import interfaz.Retorno;
import interfaz.Sistema;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Test01InicializarSistemaTest {
    private Retorno retorno;
    private final Sistema s = new ImplementacionSistema();


    @Test
    void inicializarSistemaOk() {
        retorno = s.inicializarSistema(5);
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());

        retorno = s.inicializarSistema(10);
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());

        retorno = s.inicializarSistema(15);
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());

        retorno = s.inicializarSistema(50);
        assertEquals(Retorno.Resultado.OK, retorno.getResultado());
    }

    //PREGUNTAR es necesario hacer un assertEquals con el valor string del retorno.
    @Test
    void inicializarSistemaError1() {
        retorno = s.inicializarSistema(4);
        assertEquals(Retorno.Resultado.ERROR_1, retorno.getResultado());
        assertEquals("La cantidad de ciudades a ingresar es 5 o superior.", retorno.getValorString()); //ESTO

        retorno = s.inicializarSistema(2);
        assertEquals(Retorno.Resultado.ERROR_1, retorno.getResultado());
        assertEquals("La cantidad de ciudades a ingresar es 5 o superior.", retorno.getValorString());

        retorno = s.inicializarSistema(-1);
        assertEquals(Retorno.Resultado.ERROR_1, retorno.getResultado());
        assertEquals("La cantidad de ciudades a ingresar es 5 o superior.", retorno.getValorString());

        retorno = s.inicializarSistema(0);
        assertEquals(Retorno.Resultado.ERROR_1, retorno.getResultado());
        assertEquals("La cantidad de ciudades a ingresar es 5 o superior.", retorno.getValorString());
    }




}
