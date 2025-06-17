package tp5.ejercicio2_composite;

import java.util.ArrayList;
import java.util.List;

public class Proyecto extends ItemTrabajo {
    private List<ItemTrabajo> items = new ArrayList<>();

    public Proyecto(String nombre) {
        super(nombre);
    }

    public Proyecto(String nombre, ImpresorConsola impresora) {
        super(nombre, impresora);
    }

    public void agregarItem(ItemTrabajo item) {
        item.setImpresora(this.impresora);
        items.add(item);
    }

    @Override
    public int getTiempoEstimado() {
        return items.stream().mapToInt(ItemTrabajo::getTiempoEstimado).sum();
    }

    @Override
    public void imprimir(String indent) {
        impresora.println(indent + "# " + nombre);
        for (ItemTrabajo item : items) {
            item.imprimir(indent + "  ");
        }
    }

    public void imprimir() {
        imprimir("");
    }
}
