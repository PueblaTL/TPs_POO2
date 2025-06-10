package tp5.ejercicio2_composite;

public class Tarea implements ItemTrabajo{
    private final int tiempo;

    public Tarea(int tiempo) {
        this.tiempo = tiempo;
    }

    public int tiempoEstimado() {
        return tiempo;
    }
}
