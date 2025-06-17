package tp5.ejercicio2_composite;

public abstract class ItemTrabajo {
    protected String nombre;
    protected ImpresorConsola impresora;

    public ItemTrabajo(String nombre) {
        this(nombre, new ImpresoraReal());
    }

    public ItemTrabajo(String nombre, ImpresorConsola impresora) {
        this.nombre = nombre;
        this.impresora = impresora;
    }

    public void setImpresora(ImpresorConsola impresora) {
        this.impresora = impresora;
    }

    public abstract int getTiempoEstimado();

    public abstract void imprimir(String indent);
}
