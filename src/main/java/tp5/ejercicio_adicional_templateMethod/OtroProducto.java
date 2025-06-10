package tp5.ejercicio_adicional_templateMethod;

class OtroProducto extends Producto {
    public OtroProducto(double precio) {
        super(precio);
    }

    protected double getImpuesto() {
        return 0.15;
    }

    protected double getDescuento() {
        return precio > 50 ? 0.05 : 0;
    }

    protected boolean tieneEnvioGratis() {
        return precio > 200;
    }
}
