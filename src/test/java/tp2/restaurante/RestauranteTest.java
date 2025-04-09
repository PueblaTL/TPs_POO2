package tp2.restaurante;

import org.junit.jupiter.api.Test;
import tp2.restaurante.persistance.EscritorDeArchivoEnDisco;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RestauranteTest {
    static String DIRECTORIO ="C:\\Users\\agupu\\Desktop\\Universidad Agustin\\Materias\\Tercer Año\\POO2-Practicos\\tmp\\detalle.txt";
;

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
        Comensal cliente = new Comensal(22222222, "Lucía Fernández");
        TarjetaCredito tarjetaVisa = new TarjetaCredito("Lucía Fernández", "9876543210987654", "08/26", "Visa", 456);
        Mesa mesa = new Mesa(6);
        mesa.setEscritorArchivo(escritorArchivo); // Inserta el directorio del archivo
        Producto bebida = new Producto(Producto.TipoProducto.BEBIDA, "Sprite", "Bebida sabor lima-limón", 120.0, 15);
        mesa.addProducto(bebida);
        mesa.addPedido(bebida, 2); // Pedido de 2 bebidas
        mesa.confirmarPedido();
        mesa.pagarPedido(tarjetaVisa, 3);

        // Verificar el pago con descuento del 3% en bebidas
        assertEquals(239.78, mesa.obtenerTotalConDescuento(tarjetaVisa, 3)); // Propina del 3%
    }

    public void calcularCostoConTarjetaMastercard() throws IOException {
        Path directorio = Paths.get(DIRECTORIO);

        if (!Files.exists(directorio)) {
            Files.createDirectories(directorio.getParent());
            Files.createFile(directorio);
        }
        Files.deleteIfExists(directorio);

        EscritorArchivo escritorArchivo = new EscritorDeArchivoEnDisco(directorio.toString());

        TarjetaCredito tarjetaMastercard = new TarjetaCredito("Laura Martínez", "1234987612349876", "11/26", "Mastercard", 111);
        Mesa mesa = new Mesa(4);
        mesa.setEscritorArchivo(escritorArchivo);
        Producto plato = new Producto(Producto.TipoProducto.PLATO, "Lasaña", "Lasaña de carne", 350.0, 10);
        mesa.addProducto(plato);
        mesa.addPedido(plato, 1);
        mesa.confirmarPedido();
        mesa.pagarPedido(tarjetaMastercard, 5);

        assertEquals(360.9, mesa.obtenerTotalConDescuento(tarjetaMastercard, 5));
    }

    @Test
    public void calcularCostoConTarjetaComarcaPlus() throws IOException {
        Path directorio = Paths.get(DIRECTORIO);

        if (!Files.exists(directorio)) {
            Files.createDirectories(directorio.getParent());
            Files.createFile(directorio);
        }
        Files.deleteIfExists(directorio);

        EscritorArchivo escritorArchivo = new EscritorDeArchivoEnDisco(directorio.toString());

        TarjetaCredito tarjetaComarcaPlus = new TarjetaCredito("Esteban Ríos", "9999888877776666", "05/29", "Comarca Plus", 222);
        Mesa mesa = new Mesa(4);
        mesa.setEscritorArchivo(escritorArchivo);
        Producto bebida = new Producto(Producto.TipoProducto.BEBIDA, "Limonada", "Bebida refrescante", 60.0, 10);
        Producto plato = new Producto(Producto.TipoProducto.PLATO, "Tarta", "Tarta de verdura", 220.0, 10);
        mesa.addProducto(bebida);
        mesa.addProducto(plato);
        mesa.addPedido(bebida, 1);
        mesa.addPedido(plato, 1);
        mesa.confirmarPedido();
        mesa.pagarPedido(tarjetaComarcaPlus, 2);

        assertEquals(274.68, mesa.obtenerTotalConDescuento(tarjetaComarcaPlus, 2));
    }

    @Test
    public void calcularCostoConTarjetaNoReconocida() throws IOException {
        Path directorio = Paths.get(DIRECTORIO);

        if (!Files.exists(directorio)) {
            Files.createDirectories(directorio.getParent());
            Files.createFile(directorio);
        }
        Files.deleteIfExists(directorio);

        EscritorArchivo escritorArchivo = new EscritorDeArchivoEnDisco(directorio.toString());

        TarjetaCredito tarjetaDesconocida = new TarjetaCredito("Marcelo Torres", "4444333322221111", "08/31", "Desconocida", 333);
        Mesa mesa = new Mesa(4);
        mesa.setEscritorArchivo(escritorArchivo);
        Producto bebida = new Producto(Producto.TipoProducto.BEBIDA, "Té frío", "Té con limón", 130.0, 10);
        mesa.addProducto(bebida);
        mesa.addPedido(bebida, 1);
        mesa.confirmarPedido();
        mesa.pagarPedido(tarjetaDesconocida, 5);

        assertEquals(136.5, mesa.obtenerTotalConDescuento(tarjetaDesconocida, 5));
    }

}