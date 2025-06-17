package tp5.ejercicio1_composite;

public class Main {
    public static void main(String[] args) {
        // Empleados regulares
        EmpleadoRegular e1 = new EmpleadoRegular(1000);
        EmpleadoRegular e2 = new EmpleadoRegular(1100);

        // Líder
        EmpleadoJerarquico lider = new EmpleadoJerarquico(2000);
        lider.agregarSubordinado(e1);
        lider.agregarSubordinado(e2);

        // Mando medio
        EmpleadoJerarquico mando = new EmpleadoJerarquico(3000);
        mando.agregarSubordinado(lider);

        // Gerente
        EmpleadoJerarquico gerente = new EmpleadoJerarquico(4000);
        gerente.agregarSubordinado(mando);

        // Director
        EmpleadoJerarquico director = new EmpleadoJerarquico(5000);
        director.agregarSubordinado(gerente);

        // Imprimir jerarquía
        System.out.println("=== Estructura Jerárquica ===");
        director.imprimir("");

        // Mostrar salario total
        System.out.println("\nSalario total: $" + director.calcularSalario());
    }
}
