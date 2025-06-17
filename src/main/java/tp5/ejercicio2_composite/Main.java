package tp5.ejercicio2_composite;

public class Main {
    public static void main(String[] args) {
        // Crear tareas simples
        Tarea login = new Tarea("Login de usuario", 2);
        Tarea validar = new Tarea("Validar campos", 1);
        Tarea backend = new Tarea("Conectar con base de datos", 3);

        // Crear tarea compleja
        TareaCompleja historia1 = new TareaCompleja("Historia de usuario 1");
        historia1.agregarSubtarea(login);
        historia1.agregarSubtarea(validar);

        // Tarea compleja dentro de otra
        TareaCompleja historia2 = new TareaCompleja("Historia de usuario 2");
        historia2.agregarSubtarea(backend);
        historia2.agregarSubtarea(historia1); // nesting

        // Crear proyecto y agregar ítems
        Proyecto proyecto = new Proyecto("Sistema de autenticación");
        proyecto.agregarItem(historia2);
        proyecto.agregarItem(new Tarea("Spike: investigar OAuth2", 2));

        // Imprimir todo
        proyecto.imprimir();
    }
}

