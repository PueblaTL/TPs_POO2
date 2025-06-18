package tp5.ejercicio5_templateMethod;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComercioRemerasTest {
    @Test
    public void calcularRemeraImportada(){
        Remera remera = new RemeraImportada(9000);

        assertEquals(11970,remera.calcularPrecio());
    }
    @Test
    public void calcularRemeraNacional(){
        Remera remera = new RemeraNacional(7500);

        assertEquals(10237.5,remera.calcularPrecio());
    }
}