package tp6.ejercicio4_decorador;

public abstract class Adicional implements Combo {
    protected Combo combo;

    public Adicional(Combo combo) {
        this.combo = combo;
    }

    public abstract String getDescripcion();
    public abstract double getPrecio();
}
