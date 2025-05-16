package tp3.ejercicio3;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestReporteDeGastos {

    @Test
    public void testTotalGastosComida() throws IOException {
        var gasto1 = new Gasto(Gasto.TipoDeGasto.DESAYUNO,1000);
        var gasto2 = new Gasto(Gasto.TipoDeGasto.CENA,6000);
        var reporte = new ReporteDeGastos();
        reporte.agregarGasto(gasto1);
        reporte.agregarGasto(gasto2);

        reporte.calcularGastos();

        assertEquals(7000,reporte.getTotalGastos());
    }

    @Test
    public void testTotalGastos() throws IOException {
        var gasto1 = new Gasto(Gasto.TipoDeGasto.ALQUILER_AUTO,3000);
        var gasto2 = new Gasto(Gasto.TipoDeGasto.CENA,6000);
        var reporte = new ReporteDeGastos();
        reporte.agregarGasto(gasto1);
        reporte.agregarGasto(gasto2);

        reporte.calcularGastos();

        assertEquals(9000,reporte.getTotalGastos());
    }

}
