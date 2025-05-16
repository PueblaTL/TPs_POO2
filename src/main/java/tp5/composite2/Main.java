package composite2;

public class Main {
    public static void main(String[] args) {
        PrintConsola pc = (msg) -> System.out.println(msg);
        var proyecto = new Proyecto(pc);
        TareaCompleja release = new TareaCompleja("Preparar Release");
        Tarea docu = new Tarea("Escribir Documentacion");
        Tarea changelog = new Tarea("Actualizar changelog");
        release.agregarSubtarea(docu);
        release.agregarSubtarea(changelog);

        TareaCompleja qa = new TareaCompleja("QA Testing");
        qa.agregarSubtarea(new Tarea("Correr Tests Automatizados"));
        qa.agregarSubtarea(new Tarea("Correr Tests Manuales"));

        proyecto.agregar(release);
        proyecto.agregar(qa);

        proyecto.mostrar();
    }
}
