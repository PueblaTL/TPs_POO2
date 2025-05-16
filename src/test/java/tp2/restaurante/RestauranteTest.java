package tp2.restaurante;

import org.junit.jupiter.api.Test;
import tp2.restaurante.persistance.EscritorDeArchivoEnDisco;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RestauranteTest {
    static String DIRECTORIO ="C:\\Users\\agupu\\Documents\\GitHub\\Archivos";

    @Test
    public void calcularCostoConTarjetaVisa() throws IOException {
        // Crear archivo para pruebas
        Path directorio = Paths.get(DIRECTORIO);

        // Verificar si el archivo existe, si no, crearlo
        if (!Files.exists(directorio)) {
            Files.createDirectories(directorio.getParent()); // Asegurarse de que el directorio exista
            Files.createFile(directorio); // Crea el archivo
        }
        Files.deleteIfExists(directorio); // Limpieza del archivo

        // Configurar el escritor de archivo con la ruta
        EscritorArchivo escritorArchivo = new EscritorDeArchivoEnDisco(directorio.toString());

        // Configuración
        Comensal cliente = new Comensal(11111111, "Juan Pérez");
        TarjetaCredito tarjetaVisa = new TarjetaCredito("Juan Pérez", "1234567890123456", "12/25", "Visa", 123);
        Mesa mesa = new Mesa(4);
        mesa.setEscritorArchivo(escritorArchivo); // Inserta el directorio del archivo
        Producto bebida = new Producto(Producto.TipoProducto.BEBIDA, "Coca Cola", "Bebida gaseosa", 100.0, 10);
        mesa.addProducto(bebida);
        mesa.addPedido(bebida, 2); // Pedido de 2 bebidas
        mesa.confirmarPedido();
        mesa.pagarPedido(tarjetaVisa, 3);

        // Verificar el pago con descuento del 3% en bebidas
        assertEquals(199.82, mesa.obtenerTotalConDescuento(tarjetaVisa, 3));// Propina del 3%
    }

    @Test
    public void calcularCostoConTarjetaMastercard() throws IOException{
        // Crear archivo para pruebas
        Path directorio = Paths.get(DIRECTORIO);

        // Verificar si el archivo existe, si no, crearlo
        if (!Files.exists(directorio)) {
            Files.createDirectories(directorio.getParent()); // Asegurarse de que el directorio exista
            Files.createFile(directorio); // Crea el archivo
        }
        Files.deleteIfExists(directorio); // Limpieza del archivo

        // Configurar el escritor de archivo con la ruta
        EscritorArchivo escritorArchivo = new EscritorDeArchivoEnDisco(directorio.toString());

        // Configuración
        TarjetaCredito tarjetaMastercard = new TarjetaCredito("María López", "9876543210987654", "06/27", "Mastercard", 456);
        Mesa mesa = new Mesa(4);
        mesa.setEscritorArchivo(escritorArchivo); // Inserta el directorio del archivo
        Producto plato = new Producto(Producto.TipoProducto.PLATO, "Pizza", "Pizza de muzzarella", 300.0, 10);
        mesa.addProducto(plato);
        mesa.addPedido(plato, 1); // Pedido de 1 plato
        mesa.confirmarPedido();
        mesa.pagarPedido(tarjetaMastercard, 5);

        // Verificar el pago con descuento del 2% en platos
        assertEquals(308.7, mesa.obtenerTotalConDescuento(tarjetaMastercard, 5));
    }

    @Test
    public void calcularCostoConTarjetaComarcaPlus() throws IOException{
        // Crear archivo para pruebas
        Path directorio = Paths.get(DIRECTORIO);

        // Verificar si el archivo existe, si no, crearlo
        if (!Files.exists(directorio)) {
            Files.createDirectories(directorio.getParent()); // Asegurarse de que el directorio exista
            Files.createFile(directorio); // Crea el archivo
        }
        Files.deleteIfExists(directorio); // Limpieza del archivo

        // Configurar el escritor de archivo con la ruta
        EscritorArchivo escritorArchivo = new EscritorDeArchivoEnDisco(directorio.toString());

        // Configuración
        TarjetaCredito tarjetaComarcaPlus = new TarjetaCredito("Ana Gómez", "1111222233334444", "03/28", "Comarca Plus", 789);
        Mesa mesa = new Mesa(4);
        mesa.setEscritorArchivo(escritorArchivo); // Inserta el directorio del archivo
        Producto bebida = new Producto(Producto.TipoProducto.BEBIDA, "Agua", "Agua mineral", 50.0, 10);
        Producto plato = new Producto(Producto.TipoProducto.PLATO, "Hamburguesa", "Hamburguesa con queso", 200.0, 10);
        mesa.addProducto(bebida);
        mesa.addProducto(plato);
        mesa.addPedido(bebida, 1); // Pedido de 1 bebida
        mesa.addPedido(plato, 1); // Pedido de 1 plato
        mesa.confirmarPedido();
        mesa.pagarPedido(tarjetaComarcaPlus, 2);

        // Verificar el pago con descuento del 2% total
        assertEquals(249.9, mesa.obtenerTotalConDescuento(tarjetaComarcaPlus, 2));
        //assertTrue(mesa.seConfirmoPedido());
    }

    @Test
    public void calcularCostoConTarjetaNoReconocida() throws IOException{
        // Crear archivo para pruebas
        Path directorio = Paths.get(DIRECTORIO);

        // Verificar si el archivo existe, si no, crearlo
        if (!Files.exists(directorio)) {
            Files.createDirectories(directorio.getParent()); // Asegurarse de que el directorio exista
            Files.createFile(directorio); // Crea el archivo
        }
        Files.deleteIfExists(directorio); // Limpieza del archivo

        // Configurar el escritor de archivo con la ruta
        EscritorArchivo escritorArchivo = new EscritorDeArchivoEnDisco(directorio.toString());

        // Configuración
        TarjetaCredito tarjetaViedma = new TarjetaCredito("Carlos Díaz", "5555666677778888", "07/30", "Viedma", 321);
        Mesa mesa = new Mesa(4);
        mesa.setEscritorArchivo(escritorArchivo); // Inserta el directorio del archivo
        Producto bebida = new Producto(Producto.TipoProducto.BEBIDA, "Jugo", "Jugo de naranja", 120.0, 10);
        mesa.addProducto(bebida);
        mesa.addPedido(bebida, 1); // Pedido de 1 bebida
        mesa.confirmarPedido();
        mesa.pagarPedido(tarjetaViedma, 5);

        // Verificar que no aplica descuento
        assertEquals(125.0, mesa.obtenerTotalConDescuento(tarjetaViedma, 5));
        //assertTrue(mesa.seConfirmoPedido());

    }
}