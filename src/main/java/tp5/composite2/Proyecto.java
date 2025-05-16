package composite2;

import java.util.ArrayList;
import java.util.List;

public class Proyecto {
    private List<Object> tareas = new ArrayList<>();
    private PrintConsola printer;

    public Proyecto(PrintConsola printer) {
        this.printer = printer;
    }

    public void agregar(Object tarea) {
        tareas.add(tarea);
    }

    public void mostrar() {
        for (Object tarea : tareas) {
            mostrarTarea(tarea, "");
        }
    }

    private void mostrarTarea(Object tarea, String indent) {
        if (tarea instanceof Tarea) {
            Tarea t = (Tarea) tarea;
            this.printer.println(indent + "- " + t.getNombre());
        } else if (tarea instanceof TareaCompleja) {
            TareaCompleja tc = (TareaCompleja) tarea;
            this.printer.println(indent + "+ " + tc.getNombre());
            for (Object sub : tc.getSubtareas()) {
                mostrarTarea(sub, indent + "  ");
            }
        }
    }
}
