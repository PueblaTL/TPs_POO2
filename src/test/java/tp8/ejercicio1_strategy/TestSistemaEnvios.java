package tp8.ejercicio1_strategy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSistemaEnvios {
    
    private SistemaCompras sistema;
    
    @BeforeEach
    public void setUp() {
        sistema = new SistemaCompras();
    }
    
    @Test
    public void testColectivosSur_CapitalFederal_PesoMenor5kg() {
        sistema.agregarProducto(new Producto("Notebook", 50000, 2.5));
        sistema.agregarProducto(new Producto("Mouse", 1500, 0.2));
        sistema.seleccionarFormaEnvio(new ColectivosSurStrategy());

        double costoEnvio = sistema.obtenerCostoEnvio("Capital Federal");
        double costoTotal = sistema.calcularCostoTotal("Capital Federal");

        assertEquals(1000, costoEnvio, "Costo envío CABA sin adicional por peso");
        assertEquals(52500, costoTotal, "Costo total = productos + envío");
    }
    @Test
    public void testCambioEstrategia() {
        // Arrange
        sistema.agregarProducto(new Producto("Teclado", 5000, 1));

        // Act & Assert - Colectivos Sur
        sistema.seleccionarFormaEnvio(new ColectivosSurStrategy());
        assertEquals(1000, sistema.obtenerCostoEnvio("Capital Federal"));

        // Act & Assert - Correo Argentino
        sistema.seleccionarFormaEnvio(new CorreoArgentinoStrategy());
        assertEquals(500, sistema.obtenerCostoEnvio("Capital Federal"));
    }
    }