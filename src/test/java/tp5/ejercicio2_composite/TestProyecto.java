package tp5.ejercicio2_composite;

public class TestProyecto {
    public static void main(String[] args) {
        FakeImpresorConsola impresor = new FakeImpresorConsola();

        Tarea t1 = new Tarea("Diseñar pantalla", 3, impresor);
        Tarea t2 = new Tarea("Programar backend", 5, impresor);
        Tarea t3 = new Tarea("Escribir tests", 2, impresor);

        TareaCompleja historia = new TareaCompleja("Historia: Crear login", impresor);
        historia.agregarSubtarea(t1);
        historia.agregarSubtarea(t2);
        historia.agregarSubtarea(t3);

        historia.imprimir("");

        for (String linea : impresor.getMensajes()) {
            System.out.println(linea);
        }
    }
}
