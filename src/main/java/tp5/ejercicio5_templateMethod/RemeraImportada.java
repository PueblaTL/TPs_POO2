package tp5.ejercicio5_templateMethod;

public class RemeraImportada extends Remera {
    public static final double RECARGO = 0.03;
    public static final double IMPUESTO_ADUANERO = 0.05;
    public static final double GANANCIA_COMERCIO = 0.25;

    public RemeraImportada(double precioUnitario) {
        super(precioUnitario);
    }

    @Override
    protected double calcularImpuestos() {
        return RECARGO + IMPUESTO_ADUANERO + GANANCIA_COMERCIO;
    }
}
