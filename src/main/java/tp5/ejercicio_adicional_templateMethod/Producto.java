package tp5.ejercicio_adicional_templateMethod;

abstract class Producto {
    protected double precio;

    public Producto(double precio) {
        this.precio = precio;
    }

    public final double precioFinal() {
        double impuestos = getImpuesto();
        double descuentos = getDescuento();
        boolean envioGratis = tieneEnvioGratis();

        double total = precio * (1 + impuestos) * (1 - descuentos);
        if (envioGratis) {
            total -= 10;
        }
        return total;
    }

    protected abstract double getImpuesto();
    protected abstract double getDescuento();
    protected abstract boolean tieneEnvioGratis();
}