package tp5.ejercicio4_templateMethod.conMetodoPlantilla;

import static java.time.LocalDate.now;


public class CalculadorNoJubilado extends Calculador {
    public static final double COEFICIENTE_PRECIO_SI_ES_MES_PROMOCION = 0.15;
    public static final double COEFICIENTE_PRECIO_ESTANDAR = 0.21;

    public CalculadorNoJubilado(LogTransaction log, int mes) {
        super(log, mes);
    }

    double calcularVariantePrecio() {
        if (mesEnPromocion == now().getMonth().getValue())
            return COEFICIENTE_PRECIO_SI_ES_MES_PROMOCION;
        return COEFICIENTE_PRECIO_ESTANDAR;
    }
}