package tp3.ejercicio1;
import org.junit.jupiter.api.Test;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculoDePagoTest {

    @Test
    public void calculoDePago() throws IOException {
        // set up
        var elTunel = new Libro("El Túnel", Libro.REGULARES);
        var antesDelFin = new Libro("Antes del Fin", Libro.REGULARES);
        var elTunelCopia = new CopiaLibro(elTunel);
        var antesDelFinCopia = new CopiaLibro(antesDelFin);
        var alquilerElTunel = new Alquiler(elTunelCopia, 5);
        var alquilerAntesDelFin = new Alquiler(antesDelFinCopia, 3);
        var yo = new Cliente("Javier");

        //exercise
        yo.alquilar(alquilerElTunel);
        yo.alquilar(alquilerAntesDelFin);

        var deuda = yo.calcularDeuda();
        var puntosObtenidos = yo.calcularPuntosObtenidos();

        //asserts
        assertEquals(10.0,deuda);
        assertEquals(2,puntosObtenidos);
    }

}
