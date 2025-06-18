package tp5.ejercicio5_templateMethod;

public class RemeraNacional extends Remera {
    public static final double COSTO_TRANSPORTE = 0.015;
    public static final double BONIFICACION = 0.20;
    public static final double GANANCIA_COMERCIO = 0.15;

    public RemeraNacional(double precioUnitario) {
        super(precioUnitario);
    }

    @Override
    protected double calcularImpuestos() {
        return COSTO_TRANSPORTE + BONIFICACION + GANANCIA_COMERCIO;
    }
}
