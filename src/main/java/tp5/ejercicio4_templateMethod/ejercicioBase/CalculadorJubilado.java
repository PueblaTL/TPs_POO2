package tp5.ejercicio4_templateMethod.ejercicioBase;

import static java.time.LocalDate.now;
import static java.time.Month.of;

public class CalculadorJubilado implements Calculador {
   // private LogTransaction log;
    private int mesEnPromocion;
    public double calcularPrecio(double precioProducto) {
        double precioTotal = precioProducto;
        if (!of(mesEnPromocion).equals(now().getMonth())) {
            precioTotal += precioProducto * 0.1;
        }
      //  log.log(CalculadorJubilado.class.getName());
        return precioTotal;
    }
}