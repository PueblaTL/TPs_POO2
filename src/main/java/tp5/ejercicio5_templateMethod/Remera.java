package tp5.ejercicio5_templateMethod;

public abstract class Remera {
    double precioBase;

    public Remera(double precioUnitario) {
        this.precioBase = precioUnitario;
    }

    public final double calcularPrecio(){
        return precioBase * (1 + this.calcularImpuestos());
    }
    protected abstract double calcularImpuestos();

}
