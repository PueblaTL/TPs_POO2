package tp5.ejercicio2_composite;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TestProyectoScrum {

    @Test
    public void calcularTiempoDeHistoriaUsuario() {
        // Crea tareas individuales
        Tarea t1 = new Tarea(3);
        Tarea t2 = new Tarea(2);

        // Crea un item compuesto (como una historia o spike)
        ProyectoScrum item = new ProyectoScrum();
        item.agregarItem(t1);
        item.agregarItem(t2);

        // Verificar el tiempo estimado
        assertEquals(5, item.tiempoEstimado());
    }

    @Test
    public void calcularTiempoDeProyectoCompleto() {
        // Historia (compuesta)
        ProyectoScrum historia = new ProyectoScrum();
        historia.agregarItem(new Tarea(3));
        historia.agregarItem(new Tarea(2)); // total 5

        // Spike (compuesto)
        ProyectoScrum spike = new  ProyectoScrum();
        spike.agregarItem(new Tarea(5)); // total 5

        // Proyecto completo
        ProyectoScrum proyecto = new  ProyectoScrum();
        proyecto.agregarItem(historia); // 5
        proyecto.agregarItem(spike);    // 5
        proyecto.agregarItem(new Tarea(1));

        assertEquals(11, proyecto.tiempoEstimado());
    }
}
