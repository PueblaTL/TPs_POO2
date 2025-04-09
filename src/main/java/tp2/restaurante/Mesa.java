package tp2.restaurante;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Mesa {
    static String CAPACIDAD_COMENSALES_COMPLETA = "Capacidad de comensales completa";
    static int idMesa = 0;
    private int id;
    private int capacidad;
    private boolean confirmarPedido = false;
    private ArrayList<Producto> menu;
    private ArrayList<Comensal> comensales;
    private ArrayList<Producto> pedido;
    private ArrayList<Integer> cantidades;

    private EscritorArchivo escritorArchivo;
    private Almacenamiento almacenamientoBD;

    public Mesa(int capacidad) {
        this.id = idMesa++;
        this.capacidad = capacidad;
        this.menu = new ArrayList<>();
        this.comensales = new ArrayList<>();
        this.pedido = new ArrayList<>();
        this.cantidades = new ArrayList<>();
        //this.escritorArchivo = new EscritorDeArchivoEnDisco("");
    }

    public void setAlmacenamientoBD(Almacenamiento almacenamientoBD) {this.almacenamientoBD = almacenamientoBD;}

    public void setEscritorArchivo(EscritorArchivo escritorArchivo) {
        this.escritorArchivo = escritorArchivo;
    }

    public void sentarComensal(Comensal comensal) {
        if (estaDentroCapacidad()) this.comensales.add(comensal);
        else throw new RuntimeException(CAPACIDAD_COMENSALES_COMPLETA);
    }

    private boolean estaDentroCapacidad() {
        return comensales.size() <= capacidad;
    }

    public boolean seConfirmoPedido() {
        return confirmarPedido;
    }

    public void addProducto(Producto producto) {
        this.menu.add(producto);
    }

    public void addPedido(Producto producto, int cantidad) {
        if (producto.disminuirStock(cantidad)) {
            pedido.add(producto);
            cantidades.add(cantidad);
        }
    }

    public void confirmarPedido() {
        if (pedido.size() != cantidades.size()) {
            throw new RuntimeException("El número de productos no coincide con las cantidades.");
        }
        confirmarPedido = true;
    }

    public void pagarPedido(TarjetaCredito tarjeta, int porcentajePropina) {
        if (!confirmarPedido) {
            throw new RuntimeException("El pedido debe ser confirmado antes de realizar el pago.");
        }
        String detallePago = generarDetallePago(tarjeta, porcentajePropina);
        almacenamientoBD.guardarDetalle(detallePago);
    }

    public double obtenerTotalConDescuento(TarjetaCredito tarjeta, int porcentajePropina) {
        double descuento = obtenerDescuento(tarjeta);
        double totalBebidas = obtenerTotalBedidas();
        double totalPlatos = obtenerTotalPlatos();
        double totalConDescuento = (totalBebidas + totalPlatos) - descuento;
        double propina = obtenerPropina(tarjeta, porcentajePropina);

        return totalConDescuento + propina;
    }

    private double obtenerPropina(TarjetaCredito tarjeta, int porcentajePropina) {
        double propina = ((obtenerTotalPlatos() + obtenerTotalBedidas()) - obtenerDescuento(tarjeta)) * (porcentajePropina / 100.0);
        return propina;
    }

    private double obtenerDescuento(TarjetaCredito tarjeta) {
        double descuento = 0;
        double totalBebidas = obtenerTotalBedidas();
        double totalPlatos = obtenerTotalPlatos();
        if (tarjeta.esTipo("Visa")) {descuento = totalBebidas * 0.03;} // 3% descuento en bebidas
        else if (tarjeta.esTipo("Mastercard")) {descuento = totalPlatos * 0.02;} // 2% descuento en platos
        else if (tarjeta.esTipo("Comarca Plus")) {descuento = (totalBebidas + totalPlatos) * 0.02;} // 2% descuento total
        return descuento;
    }

    private double obtenerTotalBedidas() {
        double totalBebidas = 0;
        for (int i = 0; i < pedido.size(); i++) {
            Producto producto = pedido.get(i);
            if (producto.esTipo("BEBIDA")) {
                totalBebidas += producto.getCosto() * cantidades.get(i);
            }
        }
        return totalBebidas;
    }

    private double obtenerTotalPlatos() {
        double totalPlatos = 0;
        for (int i = 0; i < pedido.size(); i++) {
            Producto producto = pedido.get(i);
            if (producto.esTipo("PLATO")) {
                totalPlatos += producto.getCosto() * cantidades.get(i);
            }
        }
        return totalPlatos;
    }

    public String generarDetallePago(TarjetaCredito tarjeta, int porcentajePropina) {
        String formatoFecha = "dd/MM/yyyy";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatoFecha);
        String detalle = "Pago realizado para la mesa: " + id + "\n" +
                "Fecha de Pago: " + LocalDate.now().format(formatter) + "\n" +
                "Total antes del descuento: $" + String.format("%.2f", obtenerTotalBedidas() + obtenerTotalPlatos()) + "\n" +
                "Descuento aplicado: $" + String.format("%.2f", obtenerDescuento(tarjeta)) + "\n" +
                "Propina (" + porcentajePropina + "%): $" + String.format("%.2f", obtenerPropina(tarjeta, porcentajePropina)) + "\n" +
                "Total final: $" + String.format("%.2f", obtenerTotalConDescuento(tarjeta, porcentajePropina)) + "\n";
        return detalle;
    }

}