package composite2;

import java.util.ArrayList;
import java.util.List;

public class TareaCompleja {
    private String nombre;
    private List<Object> subtareas = new ArrayList<>(); // No hay herencia común, usamos Object

    public TareaCompleja(String nombre) {
        this.nombre = nombre;
    }

    public void agregarSubtarea(Object tarea) {
        subtareas.add(tarea);
    }

    public String getNombre() {
        return nombre;
    }

    public List<Object> getSubtareas() {
        return subtareas;
    }
}
