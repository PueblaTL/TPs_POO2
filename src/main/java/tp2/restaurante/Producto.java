package tp2.restaurante;

public class Producto {
    static String STOCK_NO_DISPONIBLE = "Este producto no cuenta con el stock solicitado";
    static int idProducto = 0;
    private int id;
    private TipoProducto tipo; // Uso de Enum para Plato o bebida
    private String nombre;
    private String descripcion;
    private double costo;
    private int stock;

    public Producto(TipoProducto tipo, String nombre, String descripcion, double costo, int stock) {
        this.id=idProducto++;
        this.tipo = tipo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costo = costo;
        this.stock = stock;
    }

    public enum TipoProducto {
        PLATO, BEBIDA
    }

    public double getCosto() {
        return costo;
    }

    public String verProducto() {
        String detalle = "Tipo de producto: " + tipo + "\n" + "Nombre: " + nombre + "\n" + "Descripción: " + descripcion + "\n" + "Precio: $" + String.format("%.2f", costo);
        return detalle;
    }

    public boolean esTipo(String tipo) {
        return (this.tipo.name().equals(tipo));
    }


    public boolean disminuirStock(int cantidad) {
        if (stock >= cantidad) {
            stock -= cantidad;
            return true;
        } else throw new RuntimeException(STOCK_NO_DISPONIBLE);
    }


}