package tp5.ejercicio1_composite;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class TestSalario {

    @Test
    public void CalcularSalarioTotal() {
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

        double total = director.calcularSalario();
        assertEquals(16100, total);
    }

    @Test
    public void CalcularSalarioEmpleadosRegulares() {
        EmpleadoRegular emp1 = new EmpleadoRegular(1000);
        EmpleadoRegular emp2 = new EmpleadoRegular(1200);

        double total = emp1.calcularSalario() + emp2.calcularSalario();

        assertEquals(2200, total);
    }

}
