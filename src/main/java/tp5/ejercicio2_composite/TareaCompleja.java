package tp5.ejercicio2_composite;

import java.util.ArrayList;
import java.util.List;

public class TareaCompleja extends ItemTrabajo {
    private List<ItemTrabajo> subtareas = new ArrayList<>();

    public TareaCompleja(String nombre) {
        super(nombre);
    }

    public TareaCompleja(String nombre, ImpresorConsola impresora) {
        super(nombre, impresora);
    }

    public void agregarSubtarea(ItemTrabajo item) {
        item.setImpresora(this.impresora);
        subtareas.add(item);
    }

    @Override
    public int getTiempoEstimado() {
        return subtareas.stream().mapToInt(ItemTrabajo::getTiempoEstimado).sum();
    }

    @Override
    public void imprimir(String indent) {
        impresora.println(indent + "* " + nombre);
        for (ItemTrabajo sub : subtareas) {
            sub.imprimir(indent + "  ");
        }
    }
}
