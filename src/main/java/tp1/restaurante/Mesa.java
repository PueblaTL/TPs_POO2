package tp1.restaurante;

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
    private double totalBebidas;
    private double totalPlatos;

    public Mesa(int capacidad) {
        this.id = idMesa++;
        this.capacidad = capacidad;
        this.menu = new ArrayList<>();
        this.comensales = new ArrayList<>();
        this.pedido = new ArrayList<>();
        this.cantidades = new ArrayList<>();
    }

    public void sentarComensal(Comensal comensal) {
        if (estaDentroCapacidad()) this.comensales.add(comensal);
        else throw new RuntimeException(CAPACIDAD_COMENSALES_COMPLETA);
    }

    private boolean estaDentroCapacidad() {return comensales.size() <= capacidad;}

    public boolean seConfirmoPedido() {return confirmarPedido;}

    public void addProducto(Producto producto) {this.menu.add(producto);}

    public void addPedido(Producto producto, int cantidad) {
        if (producto.disminuirStock(cantidad)){
            pedido.add(producto);
            cantidades.add(cantidad);}
    }

    public void realizarPedido() {
        if (pedido.size() != cantidades.size()) {throw new RuntimeException("El número de productos no coincide con las cantidades.");}
        confirmarPedido = true;
    }

    public void pagarPedido(TarjetaCredito tarjeta, int porcentajePropina) {
        if (!confirmarPedido) {throw new RuntimeException("El pedido debe ser confirmado antes de realizar el pago.");}
        obtenerTotalBedidas();
        obtenerTotalPlatos();
        double totalFinal = obtenerTotalConDescuento(tarjeta,porcentajePropina);

    }

    public double obtenerTotalConDescuento(TarjetaCredito tarjeta, int porcentajePropina) {
        double descuento = 0;
        double totalBebidas = this.totalBebidas;
        double totalPlatos = this.totalPlatos;


        if      (tarjeta.esTipo("Visa")) {descuento = totalBebidas * 0.03;} // 3% descuento en bebidas
        else if (tarjeta.esTipo("Mastercard")) {descuento = totalPlatos * 0.02;} // 2% descuento en platos
        else if (tarjeta.esTipo("Comarca Plus")) {descuento = (totalBebidas + totalPlatos) * 0.02;} // 2% descuento total

        double totalConDescuento = (totalBebidas + totalPlatos) - descuento;
        double propina = totalConDescuento * (porcentajePropina / 100.0);

        return totalConDescuento + propina;
    }

    private void obtenerTotalBedidas() {
        totalBebidas = 0;
        for (int i = 0; i < pedido.size(); i++) {
            Producto producto = pedido.get(i);
            if (producto.esTipo("BEBIDA")) {totalBebidas += producto.getCosto() * cantidades.get(i);}
        }
    }

    private void obtenerTotalPlatos() {
        totalPlatos = 0;
        for (int i = 0; i < pedido.size(); i++) {
            Producto producto = pedido.get(i);
            if (producto.esTipo("PLATO")) {totalPlatos += producto.getCosto() * cantidades.get(i);}
        }
    }
    }