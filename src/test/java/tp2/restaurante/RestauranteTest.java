package tp2.restaurante;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RestauranteTest {

    private Producto unaBebida;
    private Producto unPlato;
    private Mesa unaMesa;
    private FakeAlmacenamiento almacenamiento;
    private TarjetaCredito tarjetaVisa;
    private TarjetaCredito tarjetaMastercard;
    private TarjetaCredito tarjetaComarcaPlus;

    @BeforeEach
    void inicializarVariables() {
        System.out.println("Inicializando variables del test...");

        // Crear productos
        this.unaBebida = new Producto(Producto.TipoProducto.BEBIDA, "Coca Cola", "Bebida gaseosa", 100.0, 10);
        this.unPlato = new Producto(Producto.TipoProducto.PLATO, "Pizza", "Pizza margherita", 500.0, 5);

        // Crear fake almacenamiento
        this.almacenamiento = new FakeAlmacenamiento();

        // Crear mesa y configurar
        this.unaMesa = new Mesa(4);

        // Verificar que la mesa no sea null
        assertNotNull(this.unaMesa, "La mesa no debería ser null después de la creación");

        this.unaMesa.setAlmacenamientoBD(almacenamiento);

        // Agregar productos a la mesa
        this.unaMesa.addProducto(unaBebida);
        this.unaMesa.addProducto(unPlato);

        // Hacer pedidos
        this.unaMesa.addPedido(unaBebida, 1); // 1 bebida de $100
        this.unaMesa.addPedido(unPlato, 1);   // 1 plato de $500

        // Crear tarjetas
        this.tarjetaVisa = new TarjetaCredito("Juan Perez", "1234567890123456", "12/25", "Visa", 123);
        this.tarjetaMastercard = new TarjetaCredito("Ana Garcia", "1111222233334444", "06/26", "Mastercard", 456);
        this.tarjetaComarcaPlus = new TarjetaCredito("Luis Martinez", "5555666677778888", "03/27", "Comarca Plus", 789);

        System.out.println("Variables inicializadas correctamente");
    }

    @Test
    public void verificarRegistroDeDetalle() {
        unaMesa.confirmarPedido();

        unaMesa.pagarPedido(tarjetaVisa, 10);

        assertTrue(almacenamiento.contieneTexto("Pago realizado para la mesa"));
        assertTrue(almacenamiento.contieneTexto("Total final"));
    }

    @Test
    void realizarPedido() {
        unaMesa.confirmarPedido();

        assertTrue(unaMesa.seConfirmoPedido());
    }

    @Test
    public void calcularCostoVisa() {
        unaMesa.confirmarPedido();

        double totalVisa = unaMesa.obtenerTotalConDescuento(tarjetaVisa, 10);

        assertEquals(656.7, totalVisa, 0.01); // 597 + 59.7 = 656.7
    }

    @Test
    public void calcularCostoMastercard() {
        assertNotNull(unaMesa, "La mesa no debería ser null");
        assertNotNull(tarjetaMastercard, "La tarjeta Mastercard no debería ser null");

        unaMesa.confirmarPedido();

        double totalMastercard = unaMesa.obtenerTotalConDescuento(tarjetaMastercard, 15);

        assertEquals(678.5, totalMastercard, 0.01); // 590 + 88.5 = 678.5
    }

    @Test
    public void calcularComarcaPlus() {
        unaMesa.confirmarPedido();

        double totalComarca = unaMesa.obtenerTotalConDescuento(tarjetaComarcaPlus, 20);

        assertEquals(705.6, totalComarca, 0.01); // 588 + 117.6 = 705.6
    }


}