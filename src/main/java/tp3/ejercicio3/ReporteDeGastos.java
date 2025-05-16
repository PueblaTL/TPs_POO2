package tp3.ejercicio3;

import java.time.LocalDate;
import java.util.ArrayList;
import static java.lang.System.*;

public class ReporteDeGastos {
    private ArrayList<Gasto> gastos = new ArrayList<>();
    private int gastosDeComida = 0;
    private int totalGastos = 0;
    private StringBuffer detalleTotal = new StringBuffer();

    public void agregarGasto(Gasto gasto) throws RuntimeException {
        gastos.add(gasto);
    }

    public int getGastosDeComida() {
        return gastosDeComida;
    }

    public int getTotalGastos() {
        return totalGastos;
    }

    public String obtenerFormatoDetalleTotal() throws RuntimeException {
        if (gastos.isEmpty()) {
            throw new RuntimeException("No hay gastos para generar el reporte");
        }

        detalleTotal.append(getExpensesDate());
        calcularGastos();
        detalleTotal.append("Gastos de comida: ")
                .append(gastosDeComida)
                .append(lineSeparator())
                .append("Total de gastos: ")
                .append(totalGastos);
        return String.valueOf(detalleTotal);
    }

    public void calcularGastos() {
        for (Gasto gasto : gastos) {
            gastosDeComida += gasto.calcularGastoDeComida();
            totalGastos += gasto.monto();
            detalleTotal.append(gasto.formatoDetalleDeGasto());
        }
    }

    private String getExpensesDate() {
        return "Expenses " + LocalDate.now() + lineSeparator();
    }
}
