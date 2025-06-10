package tp5.ejercicio_adicional_templateMethod;

class Medicina extends Producto {
    public Medicina(double precio) {
        super(precio);
    }

    protected double getImpuesto() {
        return 0;
    }

    protected double getDescuento() {
        return precio > 50 ? 0.1 : 0;
    }

    protected boolean tieneEnvioGratis() {
        return precio > 100;
    }
}
