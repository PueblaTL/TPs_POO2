package tp5.ejercicio2_composite;

public class Tarea extends ItemTrabajo {
    private int tiempo;

    public Tarea(String nombre) {
        this(nombre, 1); // Por defecto 1h si no se especifica
    }

    public Tarea(String nombre, int tiempo) {
        super(nombre);
        this.tiempo = tiempo;
    }

    public Tarea(String nombre, int tiempo, ImpresorConsola impresora) {
        super(nombre, impresora);
        this.tiempo = tiempo;
    }

    @Override
    public int getTiempoEstimado() {
        return tiempo;
    }

    @Override
    public void imprimir(String indent) {
        impresora.println(indent + "- " + nombre + " (" + tiempo + "h)");
    }
}
