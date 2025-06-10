package tp5.ejercicio_adicional_templateMethod;

class Alimento extends Producto {
    public Alimento(double precio) {
        super(precio);
    }

    protected double getImpuesto() {
        return 0.05;
    }

    protected double getDescuento() {
        return precio > 100 ? 0.15 : 0;
    }

    protected boolean tieneEnvioGratis() {
        return precio > 200;
    }
}