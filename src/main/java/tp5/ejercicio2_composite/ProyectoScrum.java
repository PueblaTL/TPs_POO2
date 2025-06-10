package tp5.ejercicio2_composite;

import java.util.ArrayList;
import java.util.List;

public class ProyectoScrum implements ItemTrabajo {
    private final List<ItemTrabajo> items = new ArrayList<>();

    public void agregarItem(ItemTrabajo item) {
        items.add(item);
    }

    @Override
    public int tiempoEstimado() {
        int tiempoTotal = 0;
        for (ItemTrabajo item : items) {
            tiempoTotal += item.tiempoEstimado();
        }
        return tiempoTotal;
    }
}
