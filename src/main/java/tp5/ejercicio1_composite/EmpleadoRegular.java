package tp5.ejercicio1_composite;

public class EmpleadoRegular implements Empleado {
    private final double salarioBase;

    public EmpleadoRegular(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    @Override
    public double calcularSalario() {
        return salarioBase;
    }
    @Override
    public void imprimir(String indent) {
        System.out.println(indent + "- Empleado Regular: $" + salarioBase);
    }
}
