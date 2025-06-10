package tp5.ejercicio1_composite;

import java.util.ArrayList;
import java.util.List;

public class EmpleadoJerarquico implements Empleado {
    private final double salarioBase;
    private final List<Empleado> subordinados = new ArrayList<>();

    public EmpleadoJerarquico(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public void agregarSubordinado(Empleado empleado) {
        subordinados.add(empleado);
    }

    @Override
    public double calcularSalario() {
        double total = salarioBase;
        for (Empleado e : subordinados) {
            total += e.calcularSalario();
        }
        return total;
    }
}
