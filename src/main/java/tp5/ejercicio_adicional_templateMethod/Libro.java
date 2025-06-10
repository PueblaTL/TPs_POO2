package tp5.ejercicio_adicional_templateMethod;

class Libro extends Producto {
    public Libro(double precio) {
        super(precio);
    }

    protected double getImpuesto() {
        return 0.1;
    }

    protected double getDescuento() {
        return 0.1;
    }

    protected boolean tieneEnvioGratis() {
        return precio > 100;
    }
}