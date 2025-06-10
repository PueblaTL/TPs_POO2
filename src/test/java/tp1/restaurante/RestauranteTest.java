package tp1.restaurante;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RestauranteTest {

    @Test
    public void calcularCostoConTarjetaVisa() {
        // Configuración
        Comensal cliente = new Comensal(22222222, "Lucía Ramírez");
        TarjetaCredito tarjetaVisa = new TarjetaCredito("Lucía Ramírez", "1111222233334444", "11/26", "Visa", 321);
        Mesa mesa = new Mesa(4);
        Producto bebida = new Producto(Producto.TipoProducto.BEBIDA, "Sprite", "Bebida sin cafeína", 100.0, 10);
        mesa.addProducto(bebida);
        mesa.addPedido(bebida, 2); // Pedido de 2 bebidas
        mesa.realizarPedido();
        mesa.pagarPedido(tarjetaVisa,3);

        // Verificar el pago con descuento del 3% en bebidas
        assertEquals(199.82, mesa.obtenerTotalConDescuento(tarjetaVisa, 3));// Propina del 3%
    }

    @Test
    public void calcularCostoConTarjetaMastercard() {
        // Configuración
        TarjetaCredito tarjetaMastercard = new TarjetaCredito("Pedro Fernández", "4444333322221111", "05/29", "Mastercard", 654);
        Mesa mesa = new Mesa(4);
        Producto plato = new Producto(Producto.TipoProducto.PLATO, "Lasaña", "Lasaña de carne", 300.0, 10);
        mesa.addProducto(plato);
        mesa.addPedido(plato, 1); // Pedido de 1 plato
        mesa.realizarPedido();
        mesa.pagarPedido(tarjetaMastercard,5);

        // Verificar el pago con descuento del 2% en platos
        assertEquals(308.7, mesa.obtenerTotalConDescuento(tarjetaMastercard, 5));
    }

    @Test
    public void calcularCostoConTarjetaComarcaPlus() {
        // Configuración
        TarjetaCredito tarjetaComarcaPlus = new TarjetaCredito("Valeria Soto", "9999888877776666", "09/26", "Comarca Plus", 147);
        Mesa mesa = new Mesa(4);
        Producto bebida = new Producto(Producto.TipoProducto.BEBIDA, "Fanta", "Fanta naranja", 50.0, 10);
        Producto plato = new Producto(Producto.TipoProducto.PLATO, "Milanesa", "Milanesa napolitana", 200.0, 10);
        mesa.addProducto(bebida);
        mesa.addProducto(plato);
        mesa.addPedido(bebida, 1); // Pedido de 1 bebida
        mesa.addPedido(plato, 1); // Pedido de 1 plato
        mesa.realizarPedido();
        mesa.pagarPedido(tarjetaComarcaPlus,2);

        // Verificar el pago con descuento del 2% total
        assertEquals(249.9, mesa.obtenerTotalConDescuento(tarjetaComarcaPlus, 2));
        //assertTrue(mesa.seConfirmoPedido());
    }

    @Test
    public void calcularCostoConTarjetaNoReconocida() {
        // Configuración
        TarjetaCredito tarjetaViedma = new TarjetaCredito("Diego Suárez", "3333444455556666", "01/31", "Banco Sur", 852);
        Mesa mesa = new Mesa(4);
        Producto bebida = new Producto(Producto.TipoProducto.BEBIDA, "Limonada", "Limonada casera", 120.0, 10);
        mesa.addProducto(bebida);
        mesa.addPedido(bebida, 1); // Pedido de 1 bebida
        mesa.realizarPedido();
        mesa.pagarPedido(tarjetaViedma,5);

        // Verificar que no aplica descuento
        assertEquals(126.0, mesa.obtenerTotalConDescuento(tarjetaViedma, 5));
        assertTrue(mesa.seConfirmoPedido());
    }
}
