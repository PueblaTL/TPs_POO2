package tp5.ejercicio2_composite;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProyectoTest {

    @Test
    public void testImpresionDeProyectoComplejo() {
        FakeImpresorConsola impresor = new FakeImpresorConsola();

        Tarea login = new Tarea("Login de usuario", 2, impresor);
        Tarea validar = new Tarea("Validar campos", 1, impresor);
        Tarea backend = new Tarea("Conectar con base de datos", 3, impresor);

        TareaCompleja historia1 = new TareaCompleja("Historia de usuario 1", impresor);
        historia1.agregarSubtarea(login);
        historia1.agregarSubtarea(validar);

        TareaCompleja historia2 = new TareaCompleja("Historia de usuario 2", impresor);
        historia2.agregarSubtarea(backend);
        historia2.agregarSubtarea(historia1);

        Proyecto proyecto = new Proyecto("Sistema de autenticación", impresor);
        proyecto.agregarItem(historia2);
        proyecto.agregarItem(new Tarea("Spike: investigar OAuth2", 2, impresor));

        proyecto.imprimir();

        List<String> mensajes = impresor.getMensajes();

        assertEquals("# Sistema de autenticación", mensajes.get(0));
        assertEquals("  * Historia de usuario 2", mensajes.get(1));
        assertEquals("    - Conectar con base de datos (3h)", mensajes.get(2));
        assertEquals("    * Historia de usuario 1", mensajes.get(3));
        assertEquals("      - Login de usuario (2h)", mensajes.get(4));
        assertEquals("      - Validar campos (1h)", mensajes.get(5));
        assertEquals("  - Spike: investigar OAuth2 (2h)", mensajes.get(6));
    }

    @Test
    public void testTamanioMensaje() {
        FakeImpresorConsola impresor = new FakeImpresorConsola();

        Tarea relevamientoRequerimientos = new Tarea("Se realiza el relevamiento de requerimientos necesarios", 2, impresor);
        Tarea daily = new Tarea("El equipo hace la reunion diaria para organizarse", 1, impresor);
        Tarea  sprint = new Tarea("Se empieza con el primer sprint", 3, impresor);

        TareaCompleja historia1 = new TareaCompleja("Inicio de nuevo proyecto", impresor);
        historia1.agregarSubtarea(relevamientoRequerimientos);
        historia1.agregarSubtarea(daily);
        historia1.agregarSubtarea(sprint);

        Proyecto proyecto = new Proyecto("Sistema para un supermercado", impresor);
        proyecto.agregarItem(historia1);


        proyecto.imprimir();

        List<String> mensajes = impresor.getMensajes();
        assertEquals("# Sistema para un supermercado", mensajes.get(0));
        assertEquals("  * Inicio de nuevo proyecto", mensajes.get(1));
        assertEquals("    - Se realiza el relevamiento de requerimientos necesarios (2h)", mensajes.get(2));
        assertEquals("    - El equipo hace la reunion diaria para organizarse (1h)", mensajes.get(3));
        assertEquals("    - Se empieza con el primer sprint (3h)", mensajes.get(4));

        assertEquals(5, mensajes.size());
    }
}
